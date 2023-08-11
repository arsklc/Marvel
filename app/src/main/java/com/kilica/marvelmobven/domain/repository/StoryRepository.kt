package com.kilica.marvelmobven.domain.repository

import com.kilica.marvelmobven.domain.model.Story

interface StoryRepository {
    suspend fun getAllStories(offset:Int):List<Story>

    suspend fun getStoryById(id:String): Story
}