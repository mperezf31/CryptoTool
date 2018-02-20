package com.mperezf.cryptotool.data

import com.mperezf.cryptotool.data.remote.RemoteDataStore
import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin
import io.reactivex.Observable

class DefaultRepository(private var mRemoteDataStore: RemoteDataStore) : Repository {

    override fun getCoins(): Observable<List<Coin>> {
        return mRemoteDataStore.coins
    }
}
