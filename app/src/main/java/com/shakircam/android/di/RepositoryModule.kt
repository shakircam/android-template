package com.shakircam.android.di

import com.shakircam.android.data.local.LocalDataSource
import com.shakircam.android.data.remote.NetworkDataSource
import com.shakircam.android.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



 /**
  * created at 08/9/2022
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

     @Provides
     @Singleton
     fun provideDermaRepo(localDataSource : LocalDataSource, remoteDataSource: NetworkDataSource): GithubRepository {
         return GithubRepository(remoteDataSource,localDataSource)
     }

}