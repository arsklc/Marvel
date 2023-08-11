package com.kilica.marvelmobven.domain.model

import com.kilica.marvelmobven.data.model.story.Characters
import com.kilica.marvelmobven.data.model.story.Comics
import com.kilica.marvelmobven.data.model.story.Creators
import com.kilica.marvelmobven.data.model.story.Events
import com.kilica.marvelmobven.data.model.story.Series

data class Story(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String,
    val events: Events,
    val id: Int,
    val series: Series,
    val title: String,
    val storyimageUrl : String
)
