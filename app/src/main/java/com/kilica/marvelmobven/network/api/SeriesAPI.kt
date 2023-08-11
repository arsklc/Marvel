package com.kilica.marvelmobven.network.api


import com.kilica.marvelmobven.data.model.series.SeriesDTO
import com.kilica.marvelmobven.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeriesAPI {
    @GET("/v1/public/series")
    suspend fun getAllSeries(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("offset") offset: String
    ): SeriesDTO

    @GET("/v1/public/series/{seriesId}")
    suspend fun getSeriesById(
        @Path("seriesId") seriesId: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("hash") hash: String,
    ): SeriesDTO
}