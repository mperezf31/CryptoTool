package com.mperezf.cryptotool.presentation.presenter

import android.support.annotation.CallSuper
import android.view.View

import com.mperezf.cryptotool.presentation.view.BaseView

abstract class BasePresenter<V : BaseView> {

    var view: V? = null
        private set

    val isAttached: Boolean
        get() = view != null

    @CallSuper
    fun attach(view: V) {
        this.view = view
    }

    @CallSuper
    fun detach() {
        view = null
    }
}
