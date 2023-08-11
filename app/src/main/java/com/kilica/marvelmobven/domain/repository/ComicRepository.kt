package com.kilica.marvelmobven.domain.repository

import com.kilica.marvelmobven.domain.model.Comic

interface ComicRepository {

    suspend fun getAllComics(offset:Int):List<Comic>

    suspend fun getComicById(id:String): Comic
}