package com.techlads.swvl.framework.common

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.MoviesResponse
import kotlinx.android.synthetic.main.props_layout.view.*
import kotlinx.android.synthetic.main.thumb_img.view.*
import java.text.FieldPosition


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.common
 */


class DetailSetter (val itemView : View) {

    fun setMovie(item: MoviesResponse.Data.Movie , pos: Int){
        itemView.movieTv.text = "Movie - " + item.year.toString()
        itemView.titleTv.text = item.title
        itemView.ratingBr.rating = item.rating.toFloat()
        itemView.genreTv.text = item.genres?.joinToString(separator = ", ")
        //-2 will only come from detail fragment
        if (pos == -2) {
            itemView.castTv.text = item.cast?.joinToString(separator = ", ")
        }
        itemView.thumbIv.setImageResource(if (pos % 2 == 0) R.drawable.thumb else R.drawable.thumb2)
    }
}