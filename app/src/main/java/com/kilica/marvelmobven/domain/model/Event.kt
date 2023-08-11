package com.kilica.marvelmobven.domain.model

import com.kilica.marvelmobven.data.model.event.Characters
import com.kilica.marvelmobven.data.model.event.Comics
import com.kilica.marvelmobven.data.model.event.Creators
import com.kilica.marvelmobven.data.model.event.Next
import com.kilica.marvelmobven.data.model.event.Previous
import com.kilica.marvelmobven.data.model.event.Series
import com.kilica.marvelmobven.data.model.event.Stories
import com.kilica.marvelmobven.data.model.event.Thumbnail
import com.kilica.marvelmobven.data.model.event.Url

data class Event(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String,
    val id: Int,
    val series: Series,
    val stories: Stories,
    val title: String,
    val eventimageUrl: String
)
