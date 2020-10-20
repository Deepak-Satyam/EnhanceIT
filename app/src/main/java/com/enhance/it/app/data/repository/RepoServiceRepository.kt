package com.enhance.it.app.data.repository

import com.enhance.it.app.data.model.Repo
import com.enhance.it.app.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class RepoServiceRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchRepo(): Single<List<Repo>> =
        networkService.doDummyCall().map { it }

}