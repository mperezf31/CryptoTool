package com.mperezf.cryptotool.presentation.view

import com.mperezf.cryptotool.domain.model.Coin

interface CoinView : BaseView{

    fun showCoins(coins : List<Coin>)
    fun onError(message : String?)
    fun onShowLoading()
    fun onHideLoading()


    interface CoinSelectedListener {
        fun onCoinSelected(coin: Coin)
    }
}