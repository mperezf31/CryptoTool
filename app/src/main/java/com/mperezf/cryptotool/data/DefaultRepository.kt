package com.mperezf.cryptotool.data

import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin
import io.reactivex.Observable

class DefaultRepository : Repository {

    override fun getCoins(): Observable<MutableList<Coin>> {
        return Observable.empty()
    }
}
