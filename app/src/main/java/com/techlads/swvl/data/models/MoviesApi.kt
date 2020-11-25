package com.techlads.swvl.data.models

import com.techlads.swvl.data.entities.MoviesResponse


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */


interface MoviesApi {
    suspend fun getContent(): MoviesResponse
}