package com.techlads.swvl.framework.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.techlads.swvl.framework.ui.detail.ItemDetailActivity
import com.techlads.swvl.framework.ui.detail.ItemDetailFragment
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.utils.Resource
import com.techlads.swvl.utils.visibility

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*

@AndroidEntryPoint
class ItemListActivity : AppCompatActivity() {

    val viewModel : HomeViewModel by viewModels()
    private var twoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        viewModel.startDataLoad()
        viewModel.movies.observe(this , onDataObserver)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        twoPane = item_detail_container != null
        setupRecyclerView(itemList)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, arrayListOf(), twoPane)
    }

    class SimpleItemRecyclerViewAdapter(private val parentActivity: ItemListActivity,
                                        private var values: List<MoviesResponse.Data.Movie>,
                                        private val twoPane: Boolean) :
            RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as MoviesResponse.Data.Movie
                if (twoPane) {
                    val fragment = ItemDetailFragment().apply {
                        arguments = Bundle().apply {
                            putParcelable(ItemDetailFragment.ARG_ITEM, item)
                        }
                    }
                    parentActivity.supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit()
                } else {
                    val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                        putExtra(ItemDetailFragment.ARG_ITEM, item)
                    }
                    v.context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.idView.text = item.year.toString()
            holder.contentView.text = item.title

            with(holder.itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.findViewById(R.id.id_text)
            val contentView: TextView = view.findViewById(R.id.content)
        }

        fun update(values: List<MoviesResponse.Data.Movie>){
            this.values = values
            notifyDataSetChanged()
        }
    }

    private val onDataObserver = object : Observer<Resource<List<MoviesResponse.Data.Movie>>> {
        override fun onChanged(it: Resource<List<MoviesResponse.Data.Movie>>?) {
            when (it?.status) {
                Resource.Status.SUCCESS -> {
                    toggleData(false)
                    if (!it.data.isNullOrEmpty()) (itemList.adapter as SimpleItemRecyclerViewAdapter).update(it.data)
                }

                Resource.Status.ERROR -> {
                    toggleData(false)
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
}