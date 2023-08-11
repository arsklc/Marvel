package com.kilica.marvelmobven.data.repository

import com.kilica.marvelmobven.data.datasource.ComicApiDataSource
import com.kilica.marvelmobven.data.mapper.Mapper.mapToComicList
import com.kilica.marvelmobven.data.mapper.Mapper.toComic
import com.kilica.marvelmobven.domain.model.Comic
import com.kilica.marvelmobven.domain.repository.ComicRepository
import javax.inject.Inject

class ComicRepositoryImpl @Inject constructor(
    private val dataSource: ComicApiDataSource
) : ComicRepository {
    override suspend fun getAllComics(offset: Int): List<Comic> {
        return dataSource.getComics(offset = offset.toString()).mapToComicList()
    }

    override suspend fun getComicById(id: String): Comic {
        return dataSource.getComicDetails(id).toComic()
    }
}