package com.kilica.marvelmobven.domain.model

import com.kilica.marvelmobven.data.model.creator.Comics
import com.kilica.marvelmobven.data.model.creator.Events
import com.kilica.marvelmobven.data.model.creator.Series
import com.kilica.marvelmobven.data.model.creator.Stories

data class Creator(
    val comics: Comics,
    val events: Events,
    val fullName: String,
    val id: Int,
    val series: Series,
    val stories: Stories,
    val creatorimageUrl: String
    )
