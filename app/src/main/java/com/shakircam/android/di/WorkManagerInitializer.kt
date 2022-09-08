package com.shakircam.android.di

import android.content.Context
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * created at 08/9/2022
 *  Shakir
 * We are trying to inject extra dependency like repository in work manager constructor But by default it's not possible without create custom work manager factory design.
 * So we are using dagger hilt factory. We need to update in manifest file & we are keeping  <provider> tag and also need to add hilt-worker dependency in build.gradle
 */

@Module
@InstallIn(SingletonComponent::class)
object WorkManagerInitializer : Initializer<WorkManager> {

    @Provides
    @Singleton
    override fun create(@ApplicationContext context: Context): WorkManager {
        val configuration = Configuration.Builder().build()
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }
}
