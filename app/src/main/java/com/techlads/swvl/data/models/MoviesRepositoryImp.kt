package com.techlads.swvl.data.models

import com.techlads.swvl.repos.MoviesRepository
import com.techlads.swvl.utils.mappers.Mapper
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */


class MoviesRepositoryImp @Inject constructor(
    private val moviesApi: MoviesApi,
    private val languageDataMapper: Mapper<String, List<MoviesResponse.Data.Movie>>
) : MoviesRepository {

    override suspend fun getMovies(): List<MoviesResponse.Data.Movie> {
        return languageDataMapper.map(moviesApi.getContent().moviesString)
    }
}