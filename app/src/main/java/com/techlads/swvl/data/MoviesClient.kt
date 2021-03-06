package com.techlads.swvl.data

import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import org.json.JSONException
import java.io.*
import javax.inject.Inject

/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl
 */

class MoviesClient @Inject constructor(private val context: Context, val moshi : Moshi) {

    companion object {
        private const val JSON_FILE = "movies.json"
        private val TAG = MoviesClient::class.java.simpleName
    }

    fun fetchBlocksDataInString(): String? {

        return try {
            val inputStream: InputStream = context.assets.open(JSON_FILE)
            val streamReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            val stringBuilder = StringBuilder()
            var input: String?

            while (streamReader.readLine().also { input = it } != null) {
                stringBuilder.append(input)
            }

            return stringBuilder.toString()
        } catch (e: JSONException) {
            Log.e(TAG, e.toString())
            null
        } catch (e: UnsupportedEncodingException) {
            Log.e(TAG, e.toString())
            null
        } catch (e: IOException) {
            Log.e(TAG, e.toString())
            null
        }
    }
}