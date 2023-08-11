package com.kilica.marvelmobven.presentation.homepage

import com.kilica.marvelmobven.domain.model.Comic

data class ComicsState(
    val shouldShowLoading : Boolean = true,
    val comics : List<Comic> = emptyList(),
    val error : String? = null
)
