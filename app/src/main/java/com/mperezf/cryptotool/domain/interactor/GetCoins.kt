package com.mperezf.cryptotool.domain.interactor

import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.domain.model.Coin
import io.reactivex.Observable
import io.reactivex.Scheduler

class GetCoins constructor(private val mRepository: Repository, mMainThread: Scheduler, mIOExecutor: Scheduler) : BaseInteractor<List<Coin>, Int>(mMainThread, mIOExecutor) {

    override fun result(params: Int): Observable<List<Coin>> {
        return mRepository.coins
    }
}
