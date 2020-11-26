package com.techlads.swvl.framework.ui.detail

import android.graphics.Color
import android.service.autofill.Dataset
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.FlickerResponse
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.framework.common.DetailSetter
import com.techlads.swvl.utils.MyDiffCallback
import com.techlads.swvl.utils.inflate
import com.techlads.swvl.utils.loadImage
import kotlinx.android.synthetic.main.item_list_content.view.*
import kotlinx.android.synthetic.main.item_list_photo.view.*
import kotlinx.android.synthetic.main.props_layout.view.*
import kotlinx.android.synthetic.main.thumb_img.view.*
import kotlinx.android.synthetic.main.thumb_img.view.thumbIv


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.ui.home
 */


class PhotosAdapter(
    private var values: List<FlickerResponse.Photos.Photo>
) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_list_photo))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.update(values[position])
    }

    override fun getItemCount() = values.size

    fun update(vals: List<FlickerResponse.Photos.Photo>) {
        this.values = vals
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun update(item: FlickerResponse.Photos.Photo) {
            Log.e("OKHTTP" , item.image())
            itemView.thumbSearchedIv.loadImage(item.image())
        }
    }
}