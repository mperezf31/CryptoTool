package com.mperezf.cryptotool.presentation.view

import com.mperezf.cryptotool.domain.model.Exchange

interface ExchangeView : BaseView {

    fun showExchange(exchanges: List<Exchange>)
    fun onError(message: String?)
    fun onShowLoading()
    fun onHideLoading()

    interface ExchangeSelectedListener {
        fun onExchangeSelected(exchange: Exchange)
    }
}