package com.mperezf.cryptotool.data.remote

import com.mperezf.cryptotool.data.mapper.CoinMapper
import com.mperezf.cryptotool.data.mapper.ExchangeMapper
import com.mperezf.cryptotool.data.model.ExchangeData
import com.mperezf.cryptotool.data.remote.responses.ResponseExchange
import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.domain.model.Exchange

import io.reactivex.Observable
import io.reactivex.functions.Function

class RemoteDataStore(private var mApiService: ApiService) : Repository {

    override fun getCoins(): Observable<List<Coin>> {
        return mApiService.getCoins().map(CoinMapper().getListMapper())
    }

    override fun getExchanges(): Observable<List<Exchange>> {
        return mApiService.getExchanges().map(Function<ResponseExchange, List<ExchangeData>> { v -> v.result }).map(ExchangeMapper().getListMapper())
    }
}
