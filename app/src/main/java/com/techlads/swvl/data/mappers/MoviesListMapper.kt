package com.techlads.swvl.data.mappers

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.techlads.swvl.data.models.MoviesResponse
import com.techlads.swvl.utils.mappers.Mapper
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.mappers
 */


class MoviesListMapper @Inject constructor(var moshi: Moshi) : Mapper<String, List<MoviesResponse.Data.Movie>> {
    override fun map(input: String?): List<MoviesResponse.Data.Movie> {
        val adapter = moshi.adapter<Any>(MoviesResponse.Data::class.java)
        val data : MoviesResponse.Data = input?.let { adapter.fromJson(it) } as MoviesResponse.Data
        return data.movies
    }
}