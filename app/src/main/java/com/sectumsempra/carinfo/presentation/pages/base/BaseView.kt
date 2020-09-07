package com.sectumsempra.carinfo.presentation.pages.base

internal interface BaseView {

    val depends
        get() = javaClass.getAnnotation(Depends::class.java)
            ?: throw Depends.AbsentDependsAnnotation()
}