package com.kilica.marvelmobven.presentation.homepage

import com.kilica.marvelmobven.domain.model.Story

data class StoriesState(
    val shouldShowLoading : Boolean = true,
    val stories : List<Story> = emptyList(),
    val error : String? = null
)
