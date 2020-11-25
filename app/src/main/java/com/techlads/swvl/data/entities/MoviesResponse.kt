package com.techlads.swvl.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */

data class MoviesResponse(val moviesString: String?) {
    data class Data(@Json(name = "movies") val movies: List<Movie>) {
        @Parcelize
        @Entity(tableName = "movies")
        data class Movie(
            @PrimaryKey(autoGenerate = true)
            val id: Int,
            @Json(name = "title") val title: String,
            @Json(name = "year") val year: Int,
            @Json(name = "cast") val cast: Array<String>,
            @Json(name = "genres") val genres: Array<String>,
            @Json(name = "rating") val rating: Int,
        ) : Parcelable
    }
}