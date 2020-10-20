package com.enhance.it.app.ui.repo

import com.enhance.it.app.data.repository.RepoServiceRepository
import com.enhance.it.app.ui.base.BaseViewModel
import com.enhance.it.app.utils.network.NetworkHelper
import com.enhance.it.app.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class RepositoryViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val repoServiceRepository: RepoServiceRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {
        // do something
    }
}