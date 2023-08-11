package com.kilica.marvelmobven.network.api

import com.kilica.marvelmobven.data.model.comic.ComicsDTO
import com.kilica.marvelmobven.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicAPI {
    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("offset") offset: String
    ): ComicsDTO

    @GET("/v1/public/comics/{comicId}")
    suspend fun getComicById(
        @Path("comicId") comicId: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("hash") hash: String,
    ): ComicsDTO
}