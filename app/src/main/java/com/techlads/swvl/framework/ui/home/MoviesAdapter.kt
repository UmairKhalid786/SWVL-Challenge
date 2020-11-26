package com.techlads.swvl.framework.ui.home

import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.framework.common.DetailSetter
import com.techlads.swvl.utils.MyDiffCallback
import com.techlads.swvl.utils.inflate


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.ui.home
 */


class MoviesAdapter(
    values: List<MoviesResponse.Data.Movie>,
    onClickListener: View.OnClickListener
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    var values: List<MoviesResponse.Data.Movie> = listOf()
    var filteredData : List<MoviesResponse.Data.Movie> = values
    var onClickListener: View.OnClickListener? = onClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_list_content))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.update(filteredData[position])
    }

    override fun getItemCount() = filteredData.size

    fun update(vals: List<MoviesResponse.Data.Movie>) {
        val diffResult: DiffUtil.DiffResult =
            DiffUtil.calculateDiff(MyDiffCallback(this.values, vals))
        this.values = arrayListOf()
        this.values = vals
        this.filteredData = this.values
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun update(item: MoviesResponse.Data.Movie) {

            val holder = DetailSetter(itemView)
            holder.setMovie(item, adapterPosition)

            with(itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }
    }
}