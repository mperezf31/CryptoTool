package com.mperezf.cryptotool.domain.interactor

import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin

import javax.inject.Inject

import io.reactivex.Observable

class GetCoins : BaseInteractor<List<Coin>, Void>() {

    @Inject var mRepository: Repository? = null

    override fun result(params: Void): Observable<List<Coin>> {
        return mRepository!!.coins
    }
}
