package com.techlads.swvl.data.repository

import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.utils.Resource


class PhotosRepositoryImpTest : PhotosRepository {

    private val photos : FlickerResponse = FlickerResponse(photos = FlickerResponse.Photos(arrayListOf()))
    private var data : Resource<FlickerResponse>? = null

    var shouldReturnNetworkError = false

    private fun refreshData(){
        if (shouldReturnNetworkError){
            data = Resource.error("Testing error" , null)
        }else{
            data = Resource.success(photos)
        }
    }


    override suspend fun getPhotos(search: String): Resource<FlickerResponse> {
        refreshData()
        return data!!
    }
}