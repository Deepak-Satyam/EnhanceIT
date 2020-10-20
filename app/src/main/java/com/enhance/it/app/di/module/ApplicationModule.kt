package com.enhance.it.app.di.module

import android.app.Application
import android.content.Context
import com.enhance.it.app.BuildConfig
import com.enhance.it.app.RepositoryApplication
import com.enhance.it.app.data.remote.NetworkService
import com.enhance.it.app.data.remote.Networking
import com.enhance.it.app.di.ApplicationContext
import com.enhance.it.app.utils.network.NetworkHelper
import com.enhance.it.app.utils.rx.RxSchedulerProvider
import com.enhance.it.app.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: RepositoryApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()



    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}