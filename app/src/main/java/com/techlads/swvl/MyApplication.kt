package com.techlads.swvl

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl
 */


@HiltAndroidApp
class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}