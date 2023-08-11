package com.kilica.marvelmobven.data.repository

import com.kilica.marvelmobven.data.datasource.StoryApiDataSource
import com.kilica.marvelmobven.data.mapper.Mapper.mapToStoriesList
import com.kilica.marvelmobven.data.mapper.Mapper.toStories
import com.kilica.marvelmobven.domain.model.Story
import com.kilica.marvelmobven.domain.repository.StoryRepository
import javax.inject.Inject

class StoryRepositoryImpl @Inject constructor(
    private val dataSource: StoryApiDataSource
) : StoryRepository {
    override suspend fun getAllStories(offset: Int): List<Story> {
        return dataSource.getStories(offset = offset.toString()).mapToStoriesList()
    }

    override suspend fun getStoryById(id: String): Story {
        return dataSource.getStoryDetails(id).toStories()
    }
}
