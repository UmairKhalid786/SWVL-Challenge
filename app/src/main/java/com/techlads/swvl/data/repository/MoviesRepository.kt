package com.techlads.swvl.data.repository

import androidx.lifecycle.LiveData
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.utils.Resource


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.repos
 */

interface MoviesRepository  {
    suspend fun getMovies() : LiveData<Resource<List<MoviesResponse.Data.Movie>>>
}