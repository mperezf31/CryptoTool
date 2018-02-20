package com.mperezf.cryptotool.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mperezf.cryptotool.CryptoToolApp
import com.mperezf.cryptotool.presentation.Navigation
import com.mperezf.cryptotool.presentation.di.component.ApplicationComponent

abstract public class BaseActivity : AppCompatActivity() {

    var mNavigation = Navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * @return Component for this application
     */
    protected fun applicationComponent(): ApplicationComponent {
        return (application as CryptoToolApp).getApplicationComponent()!!
    }
}
