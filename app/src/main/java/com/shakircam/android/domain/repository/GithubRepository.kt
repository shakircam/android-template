package com.shakircam.android.domain.repository

import com.shakircam.android.data.local.LocalDataSource
import com.shakircam.android.data.remote.NetworkDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class GithubRepository @Inject constructor(
    networkDataSource: NetworkDataSource,
    localDataSource: LocalDataSource
) {
    val remote = networkDataSource
    val local = localDataSource
}