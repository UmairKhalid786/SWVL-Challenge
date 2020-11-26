package com.techlads.swvl.framework.ui.detail

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.framework.common.BaseFragment
import com.techlads.swvl.framework.common.DetailSetter
import com.techlads.swvl.utils.Resource
import com.techlads.swvl.utils.showMessage
import com.techlads.swvl.utils.visibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_item_detail.*
import kotlinx.android.synthetic.main.item_list.*
import kotlin.random.Random

@AndroidEntryPoint
class ItemDetailFragment : BaseFragment(R.layout.fragment_item_detail) {

    private var item: MoviesResponse.Data.Movie? = null
    val viewModel : PhotosViewModel by viewModels()

    override fun init() {
        arguments?.let {
            if (it.containsKey(ARG_ITEM)) {
                item = it.getParcelable(ARG_ITEM)
                activity?.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)?.title = item?.title
            }
        }

        item?.let {
            val holder = view?.let { it1 -> DetailSetter(it1) }
            holder?.setMovie(it, -2)
        }

        setUpViewModel()
        setupRv()
    }

    private fun setupRv() {
        searchResultRv.adapter = PhotosAdapter(arrayListOf())
        searchResultRv.layoutManager = GridLayoutManager(context , 2)
    }

    private fun setUpViewModel() {
        item?.title?.let { viewModel.getPhotos(it) }
        viewModel.content.observe(viewLifecycleOwner , onDataReciveListener)
    }

    override fun listeners() {

    }

    companion object {
        const val ARG_ITEM = "item_id"

        fun getInstance(movie : MoviesResponse.Data.Movie) : ItemDetailFragment{
            val instance = ItemDetailFragment()
            instance.arguments = Bundle().apply { putParcelable(ARG_ITEM, movie) }
            return instance
        }
    }


    private val onDataReciveListener: Observer<Resource<FlickerResponse>> = Observer {
        when (it?.status) {
            Resource.Status.SUCCESS -> {
                toggleData(false)

                if (!it.data?.photos?.photos.isNullOrEmpty()) (searchResultRv.adapter as PhotosAdapter).update(
                    it.data?.photos?.photos!!
                )
            }

            Resource.Status.ERROR -> {
                toggleData(false)
                it.message?.let { it1 -> activity?.showMessage(it1) }
            }

            Resource.Status.LOADING -> {
                toggleData(true)
            }
        }
    }

    private fun toggleData(progressVisibility: Boolean) {
        searchProgBar.visibility(progressVisibility)
        searchResultRv.visibility(!progressVisibility)
    }
}