package com.techlads.swvl.di.modules

import com.squareup.moshi.Moshi
import com.techlads.swvl.data.mappers.MoviesListMapper
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.utils.mappers.Mapper
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

@Module
@InstallIn(ApplicationComponent::class)
class MappersModule{
    @Provides
    @Singleton
    fun bindsMoviesListMapper(moshi: Moshi): Mapper<String, List<MoviesResponse.Data.Movie>> {
        return MoviesListMapper(moshi)
    }
}
