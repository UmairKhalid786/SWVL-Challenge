package com.techlads.swvl.framework.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.data.repository.PhotosRepository
import com.techlads.swvl.domain.GetPhotosUseCase
import com.techlads.swvl.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.ui.detail
 */


class PhotosViewModel @androidx.hilt.lifecycle.ViewModelInject constructor(
    private val useCase: PhotosRepository
) : ViewModel(){

    private val _content = MutableLiveData<Resource<FlickerResponse>>()
    val content: LiveData<Resource<FlickerResponse>> = _content


    fun getPhotos(text : String) {
        viewModelScope.launch {
            val content = withContext(Dispatchers.IO){
                useCase.getPhotos(text)
            }

            _content.value = content
        }
    }
}