package com.mperezf.cryptotool.data

import com.mperezf.cryptotool.data.remote.RemoteDataStore
import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.domain.model.Exchange
import io.reactivex.Observable

class DefaultRepository(private var mRemoteDataStore: RemoteDataStore) : Repository {

    override fun getExchanges(): Observable<List<Exchange>> {
        return mRemoteDataStore.exchanges
    }

    override fun getCoins(): Observable<List<Coin>> {
        return mRemoteDataStore.coins
    }
}
