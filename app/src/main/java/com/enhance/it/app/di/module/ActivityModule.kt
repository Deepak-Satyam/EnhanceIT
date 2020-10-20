package com.enhance.it.app.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.enhance.it.app.data.repository.RepoServiceRepository
import com.enhance.it.app.ui.base.BaseActivity
import com.enhance.it.app.ui.repo.RepositoryViewModel
import com.enhance.it.app.utils.ViewModelProviderFactory
import com.enhance.it.app.utils.network.NetworkHelper
import com.enhance.it.app.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideRepoViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repoServiceRepository: RepoServiceRepository
    ): RepositoryViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(RepositoryViewModel::class) {
            RepositoryViewModel(schedulerProvider, compositeDisposable, networkHelper, repoServiceRepository)
        }).get(RepositoryViewModel::class.java)
}