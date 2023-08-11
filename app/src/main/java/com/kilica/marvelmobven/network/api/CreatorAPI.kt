package com.kilica.marvelmobven.network.api

import com.kilica.marvelmobven.data.model.creator.CreatorsDTO
import com.kilica.marvelmobven.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CreatorAPI {
    @GET("/v1/public/creators")
    suspend fun getAllCreators(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("offset") offset: String
    ): CreatorsDTO

    @GET("/v1/public/creators/{creatorId}")
    suspend fun getCreatorById(
        @Path("creatorId") creatorId: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("hash") hash: String,
    ): CreatorsDTO
}
