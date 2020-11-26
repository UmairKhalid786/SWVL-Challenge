package com.techlads.swvl.framework.ui.home

import android.util.Log
import android.widget.Filter
import androidx.activity.viewModels
import androidx.annotation.Nullable
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.framework.common.BaseActivity
import com.techlads.swvl.framework.ui.detail.ItemDetailFragment
import com.techlads.swvl.framework.ui.detail.MovieDetailActivity
import com.techlads.swvl.utils.AsyncTaskCoroutine
import com.techlads.swvl.utils.Resource
import com.techlads.swvl.utils.showMessage
import com.techlads.swvl.utils.visibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_movies_list.*
import kotlinx.android.synthetic.main.item_list.*


@AndroidEntryPoint
class MoviesListActivity : BaseActivity(R.layout.activity_movies_list) {

    val viewModel: HomeViewModel by viewModels()
    private var twoPane: Boolean = false

    override fun init() {
        setUpSearch()
        setupViewModel()
        decideMode()
        setupRecyclerView(itemList)
    }

    override fun listeners() {
        searchView.setOnQueryTextListener(queryListener)
    }

    override fun getToolbar(): Toolbar {
        return toolbar
    }

    private fun decideMode() {
        twoPane = item_detail_container != null
    }

    private fun setupViewModel() {
        viewModel.startDataLoad().observe(this, onDataObserver)
    }

    private fun setUpSearch() {
        searchView.queryHint = "Search in movies"
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = MoviesAdapter(arrayListOf(), onClickListener = {
            val item = it.tag as MoviesResponse.Data.Movie
            showItem(item)
        })
    }

    private fun showItem(item: MoviesResponse.Data.Movie) {
        if (twoPane) {
            val fragment = ItemDetailFragment.getInstance(movie = item)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit()
        } else {
            startActivity(MovieDetailActivity.getInstance(this, item))
        }
    }

    private val onDataObserver = object : Observer<Resource<List<MoviesResponse.Data.Movie>>> {
        override fun onChanged(it: Resource<List<MoviesResponse.Data.Movie>>?) {
            when (it?.status) {
                Resource.Status.SUCCESS -> {
                    toggleData(false)
                    if (!it.data.isNullOrEmpty()) (itemList.adapter as MoviesAdapter).update(
                        it.data
                    )
                }

                Resource.Status.ERROR -> {
                    toggleData(false)
                    it.message?.let { it1 -> showMessage(it1) }
                }

                Resource.Status.LOADING -> {
                    toggleData(true)
                }
            }
        }
    }

    private fun toggleData(progressVisibility: Boolean) {
        progressBar.visibility(progressVisibility)
        itemList.visibility(!progressVisibility)
    }

    val queryListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {

            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            newText?.let {
                if (it.length > 0)
                    filterInBgThread(it)
            }
            return true
        }
    }

    private fun filterInBgThread(newText: String) {
        val cAsy = object : AsyncTaskCoroutine<Int?, List<MoviesResponse.Data.Movie>?>() {

            override fun onPostExecute(@Nullable result:  List<MoviesResponse.Data.Movie>?) {
                if (result != null) {
                    (itemList.adapter as MoviesAdapter).filteredData = result
                    (itemList.adapter as MoviesAdapter).notifyDataSetChanged()
                }
            }

            override fun onPreExecute() {}
            override fun doInBackground(vararg params: Int?): List<MoviesResponse.Data.Movie>? {
                val filtered = (itemList.adapter as MoviesAdapter).values.filter { it.title.contains(newText) }
                val map = filtered.groupBy { it.year }

                var searched = arrayListOf<MoviesResponse.Data.Movie>()
                map.forEach {
                    searched.addAll(if (it.value.size > 5) it.value.take(5) else it.value)
                }

                Log.e("Filtered", filtered.size.toString())
                return searched
            }
        }.execute<Any>()
    }


}