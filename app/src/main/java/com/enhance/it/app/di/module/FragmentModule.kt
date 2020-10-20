package com.enhance.it.app.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.enhance.it.app.data.repository.RepoServiceRepository
import com.enhance.it.app.ui.base.BaseFragment
import com.enhance.it.app.ui.repos.ReposAdapter
import com.enhance.it.app.ui.repos.RepoViewModel
import com.enhance.it.app.utils.ViewModelProviderFactory
import com.enhance.it.app.utils.network.NetworkHelper
import com.enhance.it.app.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideReposViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repoServiceRepository: RepoServiceRepository
    ): RepoViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(RepoViewModel::class) {
                RepoViewModel(schedulerProvider, compositeDisposable, networkHelper, repoServiceRepository)
            }
        ).get(RepoViewModel::class.java)

    @Provides
    fun provideDummiesAdapter() = ReposAdapter(fragment.lifecycle, ArrayList())
}