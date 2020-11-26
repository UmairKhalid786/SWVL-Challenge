package com.techlads.swvl.data.repository

import com.techlads.swvl.data.db.MoviesDao
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.data.models.MoviesApi
import com.techlads.swvl.utils.mappers.Mapper
import com.techlads.swvl.utils.performGetOperation
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
    private val localDataSource: MoviesDao,
    private val languageDataMapper: Mapper<String, List<MoviesResponse.Data.Movie>>
) : MoviesRepository {

    override fun getMovies() = performGetOperation(
        databaseQuery = { localDataSource.getAllMovies() },
        networkCall = { languageDataMapper.map(moviesApi.getContent().moviesString) },
        saveCallResult = { localDataSource.insertAll(it) }
    )
}