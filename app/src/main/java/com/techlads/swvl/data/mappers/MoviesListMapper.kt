package com.techlads.swvl.data.mappers

import com.squareup.moshi.Moshi
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.utils.Resource
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
    override fun map(input: String?): Resource<List<MoviesResponse.Data.Movie>> {

        try {
            val adapter = moshi.adapter<Any>(MoviesResponse.Data::class.java)
            val data : MoviesResponse.Data = input?.let { adapter.fromJson(it) } as MoviesResponse.Data
            return  Resource.success(data.movies)
        }catch (e : Exception){
            return Resource.error(e.message!! , arrayListOf())
        }
    }
}