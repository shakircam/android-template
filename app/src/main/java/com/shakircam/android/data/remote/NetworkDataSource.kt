package com.shakircam.android.data.remote

import com.shakircam.android.model.Commits
import com.shakircam.android.model.Repository
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSource @Inject constructor(private val githubApi: GithubApi) {

    suspend fun getGithubCommit(): Response<MutableList<Commits.CommitsItem>> {
        return githubApi.getGithubCommit()
    }

    suspend fun getMostStarsRepository(
        searchQuery: String,
        sortBy: String,
        orderBy: String,
        pageNumber: Int,
        perPage: Int
    ): Response<Repository> {
        return githubApi.getMostStarsRepository(searchQuery, sortBy, orderBy, pageNumber, perPage)
    }


}