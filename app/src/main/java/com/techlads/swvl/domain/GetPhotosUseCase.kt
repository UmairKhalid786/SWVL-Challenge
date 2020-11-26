package com.techlads.swvl.domain

import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.data.repository.PhotosRepository
import com.techlads.swvl.utils.Resource
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.domain
 */


class GetPhotosUseCase @Inject constructor(private val photosRepository: PhotosRepository) {
    suspend fun invoke(text: String): Resource<FlickerResponse> {
        return photosRepository.getPhotos(text)
    }
}