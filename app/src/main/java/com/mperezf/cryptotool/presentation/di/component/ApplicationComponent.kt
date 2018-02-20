package com.mperezf.cryptotool.presentation.di.component

import com.mperezf.cryptotool.presentation.activity.MainActivity
import com.mperezf.cryptotool.presentation.di.module.AppModule
import com.mperezf.cryptotool.presentation.di.module.NetworkModule
import com.mperezf.cryptotool.presentation.fragment.CoinFragment

import javax.inject.Singleton

import dagger.Component

/**
 *
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: CoinFragment)
}
