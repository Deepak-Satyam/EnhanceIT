package com.enhance.it.app.ui.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.enhance.it.app.data.model.Repo
import com.enhance.it.app.ui.base.BaseItemViewModel
import com.enhance.it.app.utils.log.Logger
import com.enhance.it.app.utils.network.NetworkHelper
import com.enhance.it.app.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RepoItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Repo>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "DummyItemViewModel"
    }

    val name: LiveData<String> = Transformations.map(data) { it.name }
    val description: LiveData<String?> = Transformations.map(data) { it.description }

    fun onItemClick(position: Int) {
    }

    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }
}