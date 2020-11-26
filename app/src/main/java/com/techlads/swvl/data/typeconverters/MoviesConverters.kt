package com.techlads.swvl.data.typeconverters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.techlads.swvl.data.entities.MoviesResponse
import dagger.hilt.EntryPoint
import java.lang.reflect.Type
import java.util.*
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.typeconverters
 */



class MoviesConverters {

    @Inject
    lateinit var moshi: Moshi

    @TypeConverter
    fun storedStringToMovies(data: String?): List<MoviesResponse.Data.Movie>? {

        if (data == null) {
            return Collections.emptyList()
        }
        val type: Type = Types.newParameterizedType(
            List::class.java,
            MoviesResponse.Data.Movie::class.java
        )
        val adapter: JsonAdapter<List<MoviesResponse.Data.Movie>> = moshi.adapter(type)

        return adapter.fromJson(data)
    }

    @TypeConverter
    fun moviesToStoredString(myObjects: List<MoviesResponse.Data.Movie>?): String? {
        val type: Type = Types.newParameterizedType(
            List::class.java,
            MoviesResponse.Data.Movie::class.java
        )
        val adapter: JsonAdapter<List<MoviesResponse.Data.Movie>> = moshi.adapter(type)
        return adapter.toJson(myObjects)
    }
}