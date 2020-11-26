package com.techlads.swvl.data.repository

import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.utils.Resource


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.repos
 */

interface PhotosRepository  {
    suspend fun getPhotos(search: String): Resource<FlickerResponse>
}