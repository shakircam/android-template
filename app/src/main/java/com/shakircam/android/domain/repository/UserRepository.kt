package com.shakircam.android.domain.repository

import com.shakircam.android.model.Commits
import retrofit2.Response

interface UserRepository {

    suspend fun getGithubCommit(): Response<MutableList<Commits.CommitsItem>>
}