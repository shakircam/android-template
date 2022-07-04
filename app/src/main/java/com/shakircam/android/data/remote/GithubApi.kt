package com.shakircam.android.data.remote

import com.shakircam.android.model.Commits
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {

    @GET("repos/flutter/flutter/commits")
    suspend fun getGithubCommit(): Response<MutableList<Commits.CommitsItem>>

}