package com.techlads.swvl.framework.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.techlads.swvl.data.repository.MoviesRepositoryImpTest
import com.techlads.swvl.getOrAwaitValueTest
import com.techlads.swvl.utils.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var repositoryImpTest: MoviesRepositoryImpTest

    @Before
    fun setup() {
        repositoryImpTest = MoviesRepositoryImpTest()
        viewModel = HomeViewModel(repositoryImpTest)
    }


    @Test
    fun `get error when fetching movies`() {
        repositoryImpTest.shouldReturnNetworkError = true
        val value = viewModel.startDataLoad().getOrAwaitValueTest()

        assertThat(value.status).isEqualTo(Resource.Status.ERROR)
    }

    @Test
    fun `get success when fetching movies`() {
        repositoryImpTest.shouldReturnNetworkError = false
        val value = viewModel.startDataLoad().getOrAwaitValueTest()

        assertThat(value.status).isEqualTo(Resource.Status.SUCCESS)
    }
}