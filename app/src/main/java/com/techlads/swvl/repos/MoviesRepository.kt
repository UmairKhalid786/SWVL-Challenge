package com.techlads.swvl.repos

import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.techlads.swvl.data.MoviesClient
import com.techlads.swvl.data.models.MoviesResponse
import dagger.hilt.EntryPoint


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.repos
 */


@EntryPoint
class MoviesRepository(val moviesClient: MoviesClient) {

    val moviesLiveData: MutableLiveData<List<MoviesResponse.Movie>>? = MutableLiveData()
    fun getMovies(): MutableLiveData<List<MoviesResponse.Movie>>? {
        AsyncTask.execute({
            val data = moviesClient.fetchBlocksData()
            moviesLiveData?.postValue(data)
        })
        return moviesLiveData
    }
}