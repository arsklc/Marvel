package com.kilica.marvelmobven.domain.model

import com.kilica.marvelmobven.data.model.series.Characters
import com.kilica.marvelmobven.data.model.series.Comics
import com.kilica.marvelmobven.data.model.series.Creators
import com.kilica.marvelmobven.data.model.series.Events
import com.kilica.marvelmobven.data.model.series.Stories

data class Series(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val events: Events,
    val id: Int,
    val stories: Stories,
    val title: String,
    val seriesimageUrl: String
)
