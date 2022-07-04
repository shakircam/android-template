package com.shakircam.android.di

import android.content.Context
import androidx.room.Room
import com.shakircam.android.data.local.AppDatabase
import com.shakircam.android.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /*
      This room database instance is singleton that's mean, whole application will access single
      room database instance.

      When ever we need room database instance.
      This provide annotation will provide the room db instance dependency.
     */

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context : Context)
            = Room.databaseBuilder(context,
        AppDatabase::class.java,
        DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(database: AppDatabase) = database.userDao()
}