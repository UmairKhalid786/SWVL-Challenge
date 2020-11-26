package com.techlads.swvl.domain

import androidx.lifecycle.LiveData
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.data.repository.MoviesRepository
import com.techlads.swvl.utils.Resource
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.domain
 */


class GetMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    fun invoke(): LiveData<Resource<List<MoviesResponse.Data.Movie>>> {
        return moviesRepository.getMovies()
    }
}