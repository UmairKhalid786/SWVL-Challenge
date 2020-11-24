package com.techlads.swvl.framework.ui.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.techlads.swvl.data.models.MoviesRepositoryImp
import com.techlads.swvl.data.models.MoviesResponse
import com.techlads.swvl.domain.GetMoviesUseCase
import com.techlads.swvl.repos.MoviesRepository
import dagger.hilt.EntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.ui.home
 */

class HomeViewModel @ViewModelInject constructor(
    private val useCase: GetMoviesUseCase
) : ViewModel() {

    private val _content = MutableLiveData<List<MoviesResponse.Data.Movie>>()
    val content: LiveData<List<MoviesResponse.Data.Movie>> = _content

    fun startDataLoad() {
        viewModelScope.launch {
            val content = withContext(Dispatchers.IO) {
                useCase.invoke()
            }

            _content.value = content
        }
    }
}