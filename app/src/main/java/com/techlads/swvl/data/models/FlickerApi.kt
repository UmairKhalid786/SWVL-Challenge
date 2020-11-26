package com.techlads.swvl.data.models

import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.utils.FLICKER_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */

//&api_key=b7d089e81dfcf70fedabac8503962318&format=json&nojsoncallback=1&text=sex&page=1&per_page=10
interface FlickerApi {
    @GET("services/rest/?method=flickr.photos.search")
    suspend fun getContent(
        @Query("api_key")  apikey : String = FLICKER_API_KEY,
        @Query("format")  format : String = "json",
        @Query("nojsoncallback")  nojsoncallback : Int = 1,
        @Query("text")  text : String,
        @Query("page")  page : Int = 1,
        @Query("per_page")  perPage : Int = 10,
    ): Response<FlickerResponse>
}