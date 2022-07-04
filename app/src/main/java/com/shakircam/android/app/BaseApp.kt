package com.shakircam.android.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // initialize timber in application class
        plant(Timber.DebugTree())
    }
}