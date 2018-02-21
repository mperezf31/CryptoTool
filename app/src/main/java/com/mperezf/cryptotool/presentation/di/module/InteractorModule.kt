package com.mperezf.cryptotool.presentation.di.module

import com.mperezf.cryptotool.data.DefaultRepository
import com.mperezf.cryptotool.domain.interactor.GetCoins
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

/**
 * Network module
 */
@Module
class InteractorModule {

    @Provides
    fun provideGetCoins(defaultRepository: DefaultRepository, @Named("main") mMainThread: Scheduler, @Named("io") mIoScheduler: Scheduler): GetCoins {
        return GetCoins(defaultRepository, mMainThread, mIoScheduler)
    }

}