package com.shakircam.android.di

import com.shakircam.android.domain.repository.UserRepository
import com.shakircam.android.domain.repository.UserRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



 /**
  * Our repository is abstract & that's why we are using @Binds annotations
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        userRepositoryImp: UserRepositoryImp
    ) : UserRepository

}