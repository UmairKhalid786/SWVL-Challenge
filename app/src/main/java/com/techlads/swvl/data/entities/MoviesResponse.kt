package com.techlads.swvl.data.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.squareup.moshi.Json
import com.techlads.swvl.data.typeconverters.MoviesConverters
import com.techlads.swvl.data.typeconverters.StringsConverters
import kotlinx.android.parcel.Parcelize


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */

data class MoviesResponse(val moviesString: String?) {
    data class Data(@TypeConverters(MoviesConverters::class)
                    @Embedded
                    @Json(name = "movies")
                    val movies: List<Movie>) {

        @Parcelize
        @Entity(tableName = "movies")
        data class Movie(
            @PrimaryKey(autoGenerate = true)
            val id: Int,
            @Json(name = "title") val title: String,
            @Json(name = "year") val year: Int,
            @TypeConverters(StringsConverters::class)
            @Json(name = "cast") val cast: List<String>,
            @TypeConverters(StringsConverters::class)
            @Json(name = "genres") val genres: List<String>,
            @Json(name = "rating") val rating: Int,
        ) : Parcelable
    }
}