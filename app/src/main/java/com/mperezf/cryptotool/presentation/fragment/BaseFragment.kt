package com.mperezf.cryptotool.presentation.fragment


import android.app.Fragment

import com.mperezf.cryptotool.CryptoToolApp
import com.mperezf.cryptotool.presentation.activity.BaseActivity
import com.mperezf.cryptotool.presentation.di.component.ApplicationComponent

/**
 *
 */
abstract class BaseFragment : Fragment() {

    protected fun <T : BaseActivity> getBaseActivity(activityName: Class<T>): T {
        return activityName.cast(activity)
    }

    protected fun application(): CryptoToolApp {
        return activity.application as CryptoToolApp
    }

    protected fun component(): ApplicationComponent? {
        return application().getApplicationComponent()
    }
}
