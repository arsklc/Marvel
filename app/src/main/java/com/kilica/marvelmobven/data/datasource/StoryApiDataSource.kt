package com.kilica.marvelmobven.data.datasource


import com.kilica.marvelmobven.data.model.story.StoriesDTO
import com.kilica.marvelmobven.network.api.StoryAPI
import com.kilica.marvelmobven.util.Constants
import javax.inject.Inject

class StoryApiDataSource @Inject constructor(
    private val api: StoryAPI
) {
    suspend fun getStories(offset: String): StoriesDTO {
        return api.getAllStories(
            offset = offset,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }

    suspend fun getStoryDetails(storyId: String): StoriesDTO {
        return api.getStoryById(
            storyId = storyId,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }
}