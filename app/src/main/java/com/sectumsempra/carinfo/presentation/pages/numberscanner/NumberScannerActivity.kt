package com.sectumsempra.carinfo.presentation.pages.numberscanner

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.util.SparseArray
import android.view.SurfaceHolder
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityCompat
import androidx.core.util.forEach
import androidx.core.util.isNotEmpty
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.ActivityNumberScannerBinding
import com.sectumsempra.carinfo.presentation.pages.base.BaseActivity
import org.jetbrains.anko.displayMetrics

internal class NumberScannerActivity :
    BaseActivity<ActivityNumberScannerBinding, NumberScannerActivityViewModel>() {

    override val layoutRes = R.layout.activity_number_scanner
    override val viewModelClass = NumberScannerActivityViewModel::class

    companion object {
        private const val CAR_NUMBER = "CAR_NUMBER"
    }

    private lateinit var cameraSource: CameraSource
    private lateinit var textRecognizer: TextRecognizer

    override fun ActivityNumberScannerBinding.initUI() {
        lifecycleOwner = this@NumberScannerActivity
        viewModel = this@NumberScannerActivity.viewModel

        buildScannerTools()
        cameraView.holder.addCallback(SurfaceCameraCallback())
        textRecognizer.setProcessor(TextDetectionListener())
    }

    override fun NumberScannerActivityViewModel.observeViewModel() {

    }

    private fun buildScannerTools() {
        textRecognizer = TextRecognizer.Builder(this).build()

        cameraSource = CameraSource.Builder(this, textRecognizer)
            .setRequestedPreviewSize(displayMetrics.heightPixels, displayMetrics.widthPixels)
            .setAutoFocusEnabled(true)
            .setRequestedFps(60f)
            .build()
    }

    private inner class TextDetectionListener : Detector.Processor<TextBlock> {
        override fun release() {}

        override fun receiveDetections(textBlock: Detector.Detections<TextBlock>?) {
            val text = textBlock?.detectedItems?.values()?.joinToString() ?: "empty result"
            Log.i("textRecognition", text)

            if (textBlock?.detectedItems?.isNotEmpty() == true) {
                setResult(
                    Activity.RESULT_OK,
                    Intent().apply { putExtra(CAR_NUMBER, textBlock.detectedItems[0].value) })
                //finish()
            }
        }
    }

    private inner class SurfaceCameraCallback : SurfaceHolder.Callback {
        override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
            if (ActivityCompat.checkSelfPermission(
                    this@NumberScannerActivity,
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            cameraSource.start(binding.cameraView.holder)
        }

        override fun surfaceDestroyed(holder: SurfaceHolder?) {}

        override fun surfaceCreated(holder: SurfaceHolder?) {
            cameraSource.stop()
        }
    }

    fun SparseArray<TextBlock?>.values(): List<String> {
        val list = ArrayList<String>()
        forEach { _, value ->
            list.add(value?.value ?: "empty")
        }
        return list.toList()
    }

    class GetNumber : ActivityResultContract<Unit, String?>() {

        override fun createIntent(context: Context, input: Unit?) =
            Intent(context, NumberScannerActivity::class.java)

        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            val number = intent?.getStringExtra(CAR_NUMBER)
            return number.takeIf { it != null && resultCode == Activity.RESULT_OK }
        }
    }
}