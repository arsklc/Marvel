package com.kilica.marvelmobven.network.api

import com.kilica.marvelmobven.data.model.event.EventsDTO
import com.kilica.marvelmobven.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventAPI {
    @GET("/v1/public/events")
    suspend fun getAllEvents(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("offset") offset: String
    ): EventsDTO

    @GET("/v1/public/events/{eventId}")
    suspend fun getEventById(
        @Path("eventId") eventId: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("hash") hash: String,
    ): EventsDTO
}