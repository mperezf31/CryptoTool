package com.mperezf.cryptotool.presentation.presenter

import com.mperezf.cryptotool.domain.interactor.GetCoins
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.presentation.view.CoinView
import io.reactivex.observers.DisposableObserver

class CoinPresenter(val mGetCoins: GetCoins) : BasePresenter<CoinView>() {


    fun getCoins() {
        if (isAttached) {
            view?.onShowLoading()
        }
        mGetCoins.execute(object : DisposableObserver<List<Coin>>() {
            override fun onNext(coins: List<Coin>) {
                if (isAttached) {
                    view?.showCoins(coins)
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
