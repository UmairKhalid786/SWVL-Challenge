package com.techlads.swvl.data.repository

import android.util.Log
import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.data.models.FlickerRemoteDataSource
import com.techlads.swvl.utils.Resource
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */


class PhotosRepositoryImp @Inject constructor(
    private val api: FlickerRemoteDataSource
) : PhotosRepository {

    override suspend fun getPhotos(search: String): Resource<FlickerResponse> = api.getPhotos(search)
}