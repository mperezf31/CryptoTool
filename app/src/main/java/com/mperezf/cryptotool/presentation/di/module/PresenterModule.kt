package com.mperezf.cryptotool.presentation.di.module

import com.mperezf.cryptotool.domain.interactor.GetCoins
import com.mperezf.cryptotool.domain.interactor.GetExchanges
import com.mperezf.cryptotool.presentation.presenter.ChartPresenter
import com.mperezf.cryptotool.presentation.presenter.CoinPresenter
import com.mperezf.cryptotool.presentation.presenter.ExchangePresenter
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

    @Provides
    fun provideExchangePrenseter(getExchanges: GetExchanges): ExchangePresenter {
        return ExchangePresenter(getExchanges)
    }

    @Provides
    fun provideChartPresenter(): ChartPresenter {
        return ChartPresenter()
    }

}