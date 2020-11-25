package com.techlads.swvl.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techlads.swvl.data.entities.MoviesResponse


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.db
 */

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies() : LiveData<List<MoviesResponse.Data.Movie>>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovie(id: Int): LiveData<MoviesResponse.Data.Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MoviesResponse.Data.Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: MoviesResponse.Data.Movie)
}