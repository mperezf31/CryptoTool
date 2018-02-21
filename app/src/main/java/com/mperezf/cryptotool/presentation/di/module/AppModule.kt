package com.mperezf.cryptotool.presentation.di.module

import android.content.res.Resources
import com.mperezf.cryptotool.CryptoToolApp
import com.mperezf.cryptotool.data.DefaultRepository
import com.mperezf.cryptotool.data.remote.RemoteDataStore
import com.mperezf.cryptotool.domain.dataproviders.Repository
import com.mperezf.cryptotool.presentation.Navigation
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

/**
 * Application module
 */
@Module
class AppModule(private val mApplication: CryptoToolApp) {

    @Singleton
    @Provides
    fun provideApplication(): CryptoToolApp {
        return mApplication
    }

    @Provides
    @Singleton
    @Named("io")
    fun provideIOScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Singleton
    @Named("main")
    fun providePostExecutionThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Singleton
    @Provides
    fun provideNavigator(): Navigation {
        return Navigation
    }

    @Singleton
    @Provides
    fun provideResources(): Resources {
        return mApplication.resources
    }

    @Singleton
    @Provides
    internal fun provideRepository(remoteDataStore: RemoteDataStore): DefaultRepository {
        return DefaultRepository(remoteDataStore)
    }
}
