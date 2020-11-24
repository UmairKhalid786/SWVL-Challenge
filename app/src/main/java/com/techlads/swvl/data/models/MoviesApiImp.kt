package com.techlads.swvl.data.models

import com.techlads.swvl.data.MoviesClient


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.data.models
 */


class MoviesApiImp constructor(val imp : MoviesClient) : MoviesApi {
    override suspend fun getContent(): MoviesResponse {
        return MoviesResponse(imp.fetchBlocksDataInString())
    }
}