package com.kilica.marvelmobven.data.datasource

import com.kilica.marvelmobven.network.api.HeroAPI
import com.kilica.marvelmobven.data.model.hero.HeroesDTO
import com.kilica.marvelmobven.util.Constants
import javax.inject.Inject

class HeroApiDataSource @Inject constructor(
    private val api: HeroAPI
) {
    suspend fun getHeroes(offset: String): HeroesDTO {
        return api.getAllHeroes(
            offset = offset,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }

    suspend fun getHeroDetails(characterId: String): HeroesDTO {
        return api.getHeroById(
            characterId = characterId,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }
}