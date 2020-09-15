package com.sectumsempra.carinfo.presentation.pages.numberscanner

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.util.SparseArray
import android.view.SurfaceHolder
import androidx.core.app.ActivityCompat
import androidx.core.util.forEach
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentNumberScannerBinding
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment
import org.jetbrains.anko.displayMetrics

internal class NumberScannerFragment : BaseFragment<FragmentNumberScannerBinding, NumberScannerFragmentViewModel>() {

    override val layoutRes = R.layout.fragment_number_scanner
    override val viewModelClass = NumberScannerFragmentViewModel::class

    private lateinit var cameraSource: CameraSource
    private lateinit var textRecognizer: TextRecognizer

    override fun FragmentNumberScannerBinding.initUI() {
        lifecycleOwner = viewLifecycleOwner
        viewModel = this@NumberScannerFragment.viewModel

        buildScannerTools()
        cameraView.holder.addCallback(SurfaceCameraCallback())
        textRecognizer.setProcessor(TextDetectionListener())
    }

    override fun NumberScannerFragmentViewModel.observeViewModel() {

    }

    private fun buildScannerTools() {
        textRecognizer = TextRecognizer.Builder(requireContext()).build()

        val displayMetrics = activity?.displayMetrics ?: throw NullPointerException("Activity of ${this::class.java.simpleName} is null.")
        cameraSource = CameraSource.Builder(requireContext(), textRecognizer)
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
        }
    }

    private inner class SurfaceCameraCallback : SurfaceHolder.Callback {
        override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
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
}