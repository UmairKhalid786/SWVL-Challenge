package com.techlads.swvl.utils

import androidx.recyclerview.widget.DiffUtil
import com.techlads.swvl.data.entities.MoviesResponse


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.utils
 */


class MyDiffCallback : DiffUtil.Callback{

    var oldMovies: List<MoviesResponse.Data.Movie> = arrayListOf()
    var newMovies: List<MoviesResponse.Data.Movie> = arrayListOf()

    constructor(oldMovies : List<MoviesResponse.Data.Movie> , newMovies : List<MoviesResponse.Data.Movie>){
        this.oldMovies = oldMovies
        this.newMovies = newMovies
    }

    override fun getOldListSize(): Int {
        return oldMovies.size
    }

    override fun getNewListSize(): Int {
        return newMovies.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovies.get(oldItemPosition).id == newMovies.get(newItemPosition).id;
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovies.get(oldItemPosition).equals(newMovies.get(newItemPosition))
    }
}