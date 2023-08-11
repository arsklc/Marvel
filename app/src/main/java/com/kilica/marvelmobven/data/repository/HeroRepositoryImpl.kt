package com.kilica.marvelmobven.data.repository

import com.kilica.marvelmobven.data.datasource.HeroApiDataSource
import com.kilica.marvelmobven.data.mapper.Mapper.mapToHeroList
import com.kilica.marvelmobven.data.mapper.Mapper.toHero
import com.kilica.marvelmobven.domain.model.Hero
import com.kilica.marvelmobven.domain.repository.HeroRepository
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(
    private val dataSource: HeroApiDataSource
) : HeroRepository {
    override suspend fun getAllHeroes(offset: Int): List<Hero> {
        return dataSource.getHeroes(offset = offset.toString()).mapToHeroList()
    }

    override suspend fun getHeroById(id: String): Hero {
        return dataSource.getHeroDetails(id).toHero()
    }
}