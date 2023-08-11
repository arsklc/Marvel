package com.kilica.marvelmobven.network.api

import com.kilica.marvelmobven.data.model.hero.HeroesDTO
import com.kilica.marvelmobven.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeroAPI {
    @GET("/v1/public/characters")
    suspend fun getAllHeroes(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("offset") offset: String
    ): HeroesDTO

    @GET("/v1/public/characters/{characterId}")
    suspend fun getHeroById(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("hash") hash: String,
    ): HeroesDTO
}