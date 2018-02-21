package com.mperezf.cryptotool.presentation.di.module

import com.mperezf.cryptotool.domain.interactor.GetCoins
import com.mperezf.cryptotool.presentation.presenter.CoinPresenter
import dagger.Module
import dagger.Provides

/**
 * Network module
 */
@Module
class PresenterModule {
    @Provides
    fun provideCoinPrenseter(getCoins: GetCoins): CoinPresenter {
        return CoinPresenter(getCoins)
    }
}