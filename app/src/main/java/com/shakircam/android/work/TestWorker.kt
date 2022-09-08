package com.shakircam.android.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.shakircam.android.domain.repository.GithubRepository
import com.shakircam.android.model.User
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * created at 08/9/2022
 * Shakir
 * Here we are adding extra dependency(GithubRepository) & now we can call our network client or UserDao.
 * If you need any long running background operation you can put your code statement here.
 */

@HiltWorker
class TestWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val githubRepository: GithubRepository
    ) : CoroutineWorker(
    appContext,
    params
) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {

            for (i in 1..20){
                Timber.d("number:$i")
            }

            Result.success()

        } catch (e: Exception) {
            Result.failure()
        }

    }

    private suspend fun fakeNetworkCall() {
       githubRepository.remote.getGithubCommit()
    }

    private suspend fun addUser() {
        val user = User(1,"Jamal","haque")
        githubRepository.local.insertUserInformation(user)
    }

}