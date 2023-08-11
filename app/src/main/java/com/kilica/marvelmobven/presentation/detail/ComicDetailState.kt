package com.kilica.marvelmobven.presentation.detail

import com.kilica.marvelmobven.domain.model.Comic

data class ComicDetailState(
    val isLoading : Boolean = false,
    val comic : Comic? = null,
    val error : String = ""
)
