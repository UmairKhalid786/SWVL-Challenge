package com.techlads.swvl.domain

import com.techlads.swvl.data.models.MoviesResponse
import com.techlads.swvl.repos.MoviesRepository
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.domain
 */


class GetMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(): List<MoviesResponse.Data.Movie> {
        return moviesRepository.getMovies()
    }
}