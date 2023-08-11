package com.kilica.marvelmobven.data.datasource

import com.kilica.marvelmobven.data.model.comic.ComicsDTO
import com.kilica.marvelmobven.network.api.ComicAPI
import com.kilica.marvelmobven.util.Constants
import javax.inject.Inject

class ComicApiDataSource @Inject constructor(
    private val comicapi: ComicAPI
) {
    suspend fun getComics(offset: String): ComicsDTO {
        return comicapi.getAllComics(
            offset = offset,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }

    suspend fun getComicDetails(comicId: String): ComicsDTO {
        return comicapi.getComicById(
            comicId = comicId,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }
}