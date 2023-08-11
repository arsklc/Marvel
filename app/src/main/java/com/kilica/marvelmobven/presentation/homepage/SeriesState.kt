package com.kilica.marvelmobven.presentation.homepage

import com.kilica.marvelmobven.domain.model.Series

data class SeriesState(
    val shouldShowLoading : Boolean = true,
    val series : List<Series> = emptyList(),
    val error : String? = null
)
