package com.kilica.marvelmobven.domain.repository

import com.kilica.marvelmobven.domain.model.Hero

interface HeroRepository {

    suspend fun getAllHeroes(offset:Int):List<Hero>

    suspend fun getHeroById(id:String):Hero

}