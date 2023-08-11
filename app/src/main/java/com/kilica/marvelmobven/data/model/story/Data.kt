package com.kilica.marvelmobven.data.model.story

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<StoryResult>,
    val total: Int
)