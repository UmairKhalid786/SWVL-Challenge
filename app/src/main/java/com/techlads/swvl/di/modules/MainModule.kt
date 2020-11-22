package com.techlads.swvl.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.di.modules
 */

@InstallIn(ApplicationComponent::class)
@Module
class MainModule  {

    @Singleton
    @Provides
    fun providesMoshi() =  Moshi.Builder().build()
}