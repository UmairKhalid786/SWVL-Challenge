package com.techlads.swvl.data.models

import com.techlads.swvl.data.BaseDataSource
import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.utils.FLICKER_API_KEY
import retrofit2.http.Query
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */


class FlickerRemoteDataSource @Inject constructor(
    private val api: FlickerApi
) : BaseDataSource() {

    suspend fun getPhotos(
        text: String
    ) = getResult { api.getContent(text = text ) }
}