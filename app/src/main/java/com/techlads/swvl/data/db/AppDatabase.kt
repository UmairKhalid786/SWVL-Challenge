package com.techlads.swvl.data.db

import android.content.Context
import androidx.room.*
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.data.typeconverters.MoviesConverters
import com.techlads.swvl.data.typeconverters.StringsConverters


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.db
 */


@Database(entities = [MoviesResponse.Data.Movie::class],  version = 1, exportSchema = false)
@TypeConverters(MoviesConverters::class, StringsConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "movies_db")
                .fallbackToDestructiveMigration()
                .build()
    }
}