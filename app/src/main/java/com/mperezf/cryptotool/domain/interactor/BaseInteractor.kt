package com.mperezf.cryptotool.domain.interactor

import javax.inject.Inject
import javax.inject.Named

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class BaseInteractor<T, P> {

    @Inject
    @Named("main")
    var mMainThread: Scheduler? = null

    @Inject
    @Named("io")
    var mIOExecutor: Scheduler? = null

    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    protected abstract fun result(params: P): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: P) {
        val observable = result(params)
                .subscribeOn(mIOExecutor!!)
                .observeOn(mMainThread!!)
        mCompositeDisposable.add(observable.subscribeWith(observer))
    }

    /**
     * Disposes all resources
     */
    fun close() {
        if (!mCompositeDisposable.isDisposed) {
            mCompositeDisposable.dispose()
        }
    }
}