package com.enhance.it.app.ui.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.enhance.it.app.data.model.Repo
import com.enhance.it.app.data.repository.RepoServiceRepository
import com.enhance.it.app.ui.base.BaseViewModel
import com.enhance.it.app.utils.common.Resource
import com.enhance.it.app.utils.common.Status
import com.enhance.it.app.utils.network.NetworkHelper
import com.enhance.it.app.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class RepoViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val repoServiceRepository: RepoServiceRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val repoLiveData: MutableLiveData<Resource<List<Repo>>> = MutableLiveData()

    fun getDummies(): LiveData<List<Repo>> =
        Transformations.map(repoLiveData) { it.data }

    fun isDummiesFetching(): LiveData<Boolean> =
        Transformations.map(repoLiveData) { it.status == Status.LOADING }

    override fun onCreate() {
        if (repoLiveData.value == null && checkInternetConnectionWithMessage()) {
            repoLiveData.postValue(Resource.loading())
            compositeDisposable.add(
                repoServiceRepository.fetchRepo()
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { repoLiveData.postValue(Resource.success(it)) },
                        {
                            handleNetworkError(it)
                            repoLiveData.postValue(Resource.error())
                        })
            )
        }
    }
}