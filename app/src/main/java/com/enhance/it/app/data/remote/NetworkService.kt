package com.enhance.it.app.data.remote

import com.enhance.it.app.data.model.Repo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import javax.inject.Singleton

@Singleton
interface NetworkService {


    @GET(Endpoints.REPOS)
    fun doDummyCall(
    ): Single<List<Repo>>
}