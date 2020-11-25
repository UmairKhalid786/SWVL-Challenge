package com.techlads.swvl.di.modules

import com.techlads.swvl.data.models.MoviesRepositoryImp
import com.techlads.swvl.data.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.di.modules
 */


@Module
@InstallIn(ApplicationComponent::class)
abstract class MoviesModule {
    @Binds
    abstract fun provideMoviesRepository(contentRepositoryImpl: MoviesRepositoryImp): MoviesRepository
}