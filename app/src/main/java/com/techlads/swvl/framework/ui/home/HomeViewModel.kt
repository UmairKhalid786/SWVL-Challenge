package com.techlads.swvl.framework.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techlads.swvl.data.models.MoviesResponse
import com.techlads.swvl.repos.MoviesRepository
import dagger.hilt.EntryPoint


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.ui.home
 */

@EntryPoint
class HomeViewModel(val repository: MoviesRepository) : ViewModel() {

    fun getMovies(): MutableLiveData<List<MoviesResponse.Movie>>? {
        return repository.getMovies()
    }
}