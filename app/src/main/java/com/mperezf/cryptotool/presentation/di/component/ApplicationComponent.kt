package com.mperezf.cryptotool.presentation.di.component

import com.mperezf.cryptotool.presentation.activity.MainActivity
import com.mperezf.cryptotool.presentation.di.module.AppModule
import com.mperezf.cryptotool.presentation.di.module.InteractorModule
import com.mperezf.cryptotool.presentation.di.module.NetworkModule
import com.mperezf.cryptotool.presentation.di.module.PresenterModule
import com.mperezf.cryptotool.presentation.fragment.CoinFragment
import com.mperezf.cryptotool.presentation.fragment.ExchangeFragment

import javax.inject.Singleton

import dagger.Component

/**
 *
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, InteractorModule::class, PresenterModule::class))
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: CoinFragment)
    fun inject(fragment: ExchangeFragment)
}
