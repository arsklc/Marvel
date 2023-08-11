package com.kilica.marvelmobven.presentation.detail

import com.kilica.marvelmobven.domain.model.Story

data class StoryDetailState(
    val isLoading : Boolean = false,
    val story: Story? = null,
    val error : String = ""
)
