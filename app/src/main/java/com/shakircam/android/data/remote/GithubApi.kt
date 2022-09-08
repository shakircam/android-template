package com.shakircam.android.data.remote

import com.shakircam.android.model.Commits
import com.shakircam.android.model.Repository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("repos/flutter/flutter/commits")
    suspend fun getGithubCommit(): Response<MutableList<Commits.CommitsItem>>

    @GET("search/repositories")
    suspend fun getMostStarsRepository(
        @Query("q")searchQuery : String,
        @Query("sort") sortBy : String,
        @Query("order") orderBy : String,
        @Query("page")page : Int,
        @Query("per_page")perPage : Int,
    ):Response<Repository>
}