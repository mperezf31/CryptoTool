package com.mperezf.cryptotool.presentation.presenter

import com.mperezf.cryptotool.domain.interactor.GetExchanges
import com.mperezf.cryptotool.domain.model.Exchange
import com.mperezf.cryptotool.presentation.view.ExchangeView
import io.reactivex.observers.DisposableObserver

class ExchangePresenter(val mGetExchanges: GetExchanges) : BasePresenter<ExchangeView>() {

    fun getExchanges() {
        if (isAttached) {
            view?.onShowLoading()
        }
        mGetExchanges.execute(object : DisposableObserver<List<Exchange>>() {
            override fun onNext(coins: List<Exchange>) {
                if (isAttached) {
                    view?.showExchange(coins)
                }
            }

            override fun onError(e: Throwable) {
                if (isAttached) {
                    view?.onHideLoading()
                    view?.onError(e.message)
                }
            }

            override fun onComplete() {
                if (isAttached) {
                    view?.onHideLoading()
                }
            }
        }, 0)
    }
}