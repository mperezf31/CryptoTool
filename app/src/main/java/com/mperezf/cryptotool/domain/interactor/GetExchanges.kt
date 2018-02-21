package com.mperezf.cryptotool.domain.interactor

import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.domain.model.Exchange
import io.reactivex.Observable
import io.reactivex.Scheduler

class GetExchanges constructor(private val mRepository: Repository, mMainThread: Scheduler, mIOExecutor: Scheduler) : BaseInteractor<List<Exchange>, Int>(mMainThread, mIOExecutor) {

    override fun result(params: Int): Observable<List<Exchange>> {
        return mRepository.exchanges
    }
}