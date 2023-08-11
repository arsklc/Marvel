package com.kilica.marvelmobven.presentation.detail

import com.kilica.marvelmobven.domain.model.Series

data class SeriesDetailState(
    val isLoading : Boolean = false,
    val series: Series? = null,
    val error : String = ""
)
