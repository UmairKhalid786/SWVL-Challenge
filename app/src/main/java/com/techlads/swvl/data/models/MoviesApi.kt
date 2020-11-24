package com.techlads.swvl.data.models

import retrofit2.http.GET


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