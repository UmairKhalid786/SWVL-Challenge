package com.techlads.swvl.framework.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.techlads.swvl.data.repository.PhotosRepositoryImpTest
import com.techlads.swvl.getOrAwaitValueTest
import com.techlads.swvl.utils.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PhotosViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: PhotosViewModel
    private lateinit var repositoryImpTest: PhotosRepositoryImpTest

    @Before
    fun setup() {
        repositoryImpTest = PhotosRepositoryImpTest()
        viewModel = PhotosViewModel(repositoryImpTest)
    }


    @Test
    fun `get error when fetching photos`() {
        repositoryImpTest.shouldReturnNetworkError = true
        viewModel.getPhotos("any name")
        val value = viewModel.content.getOrAwaitValueTest()
        Truth.assertThat(value.status).isEqualTo(Resource.Status.ERROR)
    }

    @Test
    fun `get success when fetching photos`() {
        repositoryImpTest.shouldReturnNetworkError = false
        viewModel.getPhotos("any name")
        val value = viewModel.content.getOrAwaitValueTest()
        Truth.assertThat(value.status).isEqualTo(Resource.Status.SUCCESS)
    }
}