package com.techlads.swvl.repos

import com.techlads.swvl.data.models.MoviesResponse


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.repos
 */

interface MoviesRepository  {
    suspend fun getMovies() : List<MoviesResponse.Data.Movie>
}