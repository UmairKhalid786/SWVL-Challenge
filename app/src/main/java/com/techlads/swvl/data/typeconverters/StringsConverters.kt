package com.techlads.swvl.data.typeconverters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.techlads.swvl.data.entities.MoviesResponse
import dagger.hilt.EntryPoint
import java.lang.reflect.Type
import java.util.*
import javax.inject.Inject


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.typeconverters
 */


class StringsConverters {

    var moshi: Moshi = Moshi.Builder().build()

    @TypeConverter
    fun storedStringToStrings(data: String?): List<String>? {

        if (data == null) {
            return Collections.emptyList()
        }
        val type: Type = Types.newParameterizedType(
            List::class.java,
            String::class.java
        )
        val adapter: JsonAdapter<List<String>> = moshi.adapter(type)

        return adapter.fromJson(data)
    }

    @TypeConverter
    fun listToStoredString(myObjects: List<String>?): String? {
        val type: Type = Types.newParameterizedType(
            List::class.java,
            String::class.java
        )
        val adapter: JsonAdapter<List<String>> = moshi.adapter(type)
        return adapter.toJson(myObjects)
    }
}