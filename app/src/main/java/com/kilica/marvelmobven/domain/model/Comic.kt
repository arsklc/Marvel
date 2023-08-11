package com.kilica.marvelmobven.domain.model

import com.kilica.marvelmobven.data.model.comic.Characters
import com.kilica.marvelmobven.data.model.comic.Creators
import com.kilica.marvelmobven.data.model.comic.Events
import com.kilica.marvelmobven.data.model.comic.Series
import com.kilica.marvelmobven.data.model.comic.Stories
import com.kilica.marvelmobven.data.model.comic.Thumbnail


data class Comic(
    val characters: Characters,
    val creators: Creators,
    val description: String,
    val events: Events,
    val id: Int,
    val series: Series,
    val stories: Stories,
    val title: String,
    val comicimageUrl: String,
)