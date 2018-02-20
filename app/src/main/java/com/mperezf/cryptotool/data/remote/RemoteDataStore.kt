package com.mperezf.cryptotool.data.remote

import com.mperezf.cryptotool.data.mapper.CoinMapper
import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin

import io.reactivex.Observable

class RemoteDataStore(private var mApiService: ApiService) : Repository {

    override fun getCoins(): Observable<List<Coin>> {
        return mApiService.getCoins().map(CoinMapper().getListMapper())
    }
}
