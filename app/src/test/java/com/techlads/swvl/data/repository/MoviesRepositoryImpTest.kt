package com.techlads.swvl.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.utils.Resource

class MoviesRepositoryImpTest : MoviesRepository {

    private val movies : List<MoviesResponse.Data.Movie> = mutableListOf()
    private val observeableLiveDataMovies = MutableLiveData<Resource<List<MoviesResponse.Data.Movie>>>()

    var shouldReturnNetworkError = false

    private fun refreshData(){
        if (shouldReturnNetworkError){
            observeableLiveDataMovies.postValue(Resource.error("Testing error" , null))
        }else{
            observeableLiveDataMovies.postValue(Resource.success(movies))
        }
    }
    override fun getMovies(): LiveData<Resource<List<MoviesResponse.Data.Movie>>> {
        refreshData()
        return observeableLiveDataMovies
    }
}