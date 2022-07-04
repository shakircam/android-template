package com.shakircam.android.domain.repository

import android.app.Application
import com.shakircam.android.data.remote.GithubApi
import com.shakircam.android.model.Commits
import retrofit2.Response
import javax.inject.Inject


 /*

 */


 class UserRepositoryImp @Inject constructor(
    private val githubApi: GithubApi
) : UserRepository {

    override suspend fun getGithubCommit(): Response<MutableList<Commits.CommitsItem>> {
        return githubApi.getGithubCommit()
    }
}