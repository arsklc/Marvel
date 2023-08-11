package com.kilica.marvelmobven.network.api

import com.kilica.marvelmobven.data.model.story.StoriesDTO
import com.kilica.marvelmobven.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoryAPI {
    @GET("/v1/public/stories")
    suspend fun getAllStories(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("offset") offset: String
    ): StoriesDTO

    @GET("/v1/public/stories/{storyId}")
    suspend fun getStoryById(
        @Path("storyId") storyId: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("hash") hash: String,
    ): StoriesDTO
}