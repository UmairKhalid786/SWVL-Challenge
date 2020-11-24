package com.techlads.swvl.data.models

import com.squareup.moshi.Json


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */


data class MoviesResponse(val moviesString: String?) {
    data class Data(@Json(name = "movies") val movies: List<Movie>) {
        data class Movie(
            @Json(name = "title") val title: String,
            @Json(name = "year") val year: Int,
            @Json(name = "cast") val cast: Array<String>,
            @Json(name = "genres") val genres: Array<String>,
            @Json(name = "rating") val rating: Int,
        )
    }
}