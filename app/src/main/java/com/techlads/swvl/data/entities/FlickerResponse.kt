package com.techlads.swvl.data.entities

import com.squareup.moshi.Json
import com.techlads.swvl.utils.Utils


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.entities
 */


data class FlickerResponse(
    @field:Json(name = "photos")
    val photos: Photos) {

    data class Photos(
        @field:Json(name = "photo")
        val photos: List<Photo>) {

        data class Photo(
            @field:Json(name = "id") val id: String,
            @field:Json(name = "owner") val owner: String,
            @field:Json(name = "secret") val secret: String,
            @field:Json(name = "title") val title: String,
            @field:Json(name = "farm") val farm: String,
            @field:Json(name = "server") val server: String) {

            fun image() = Utils.replaceAll(this)
        }
    }
}