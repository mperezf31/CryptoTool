package com.mperezf.cryptotool

import android.app.Application
import com.mperezf.cryptotool.presentation.di.component.ApplicationComponent
import com.mperezf.cryptotool.presentation.di.component.DaggerApplicationComponent
import com.mperezf.cryptotool.presentation.di.module.AppModule
import com.mperezf.cryptotool.presentation.di.module.NetworkModule

class CryptoToolApp : Application(){

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(BuildConfig.SERVER_URL))
                .build()
    }

    /**
     * @return The ApplicationComponent
     */
    fun getApplicationComponent(): ApplicationComponent? {
        return mApplicationComponent
    }
}