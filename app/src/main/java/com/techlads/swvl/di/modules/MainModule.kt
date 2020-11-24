package com.techlads.swvl.di.modules

import android.content.Context
import com.squareup.moshi.Moshi
import com.techlads.swvl.data.MoviesClient
import com.techlads.swvl.data.models.MoviesApi
import com.techlads.swvl.data.models.MoviesApiImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun providesMoviesClient(@ApplicationContext appContext: Context, moshi: Moshi) =  MoviesClient(appContext , moshi)

    @Singleton
    @Provides
    fun provideApi(client: MoviesClient) : MoviesApi {
        return MoviesApiImp(client)
    }
}