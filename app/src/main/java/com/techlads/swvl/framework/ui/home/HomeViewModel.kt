package com.techlads.swvl.framework.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.data.repository.MoviesRepository
import com.techlads.swvl.domain.GetMoviesUseCase
import com.techlads.swvl.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.ui.home
 */

class HomeViewModel @ViewModelInject constructor(
    private val useCase: MoviesRepository) : ViewModel() {

    fun startDataLoad() : LiveData<Resource<List<MoviesResponse.Data.Movie>>> = useCase.getMovies()
}