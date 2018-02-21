package com.mperezf.cryptotool.data.remote

import com.mperezf.cryptotool.data.model.CoinData
import com.mperezf.cryptotool.data.remote.responses.ResponseExchange
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    /**
     * GET coin values
     */
    @GET("ticker/")
    fun getCoins(): Observable<List<CoinData>>

    /**
     * GET exchanges
     */
    @GET("https://api.cryptowat.ch/exchanges")
    fun getExchanges(): Observable<ResponseExchange>

}