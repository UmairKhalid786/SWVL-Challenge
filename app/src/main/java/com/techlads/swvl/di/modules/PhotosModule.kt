package com.techlads.swvl.di.modules

import com.techlads.swvl.data.repository.MoviesRepositoryImp
import com.techlads.swvl.data.repository.MoviesRepository
import com.techlads.swvl.data.repository.PhotosRepository
import com.techlads.swvl.data.repository.PhotosRepositoryImp
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
abstract class PhotosModule {
    @Binds
    abstract fun providePhotosRepository(contentRepositoryImpl: PhotosRepositoryImp): PhotosRepository
}