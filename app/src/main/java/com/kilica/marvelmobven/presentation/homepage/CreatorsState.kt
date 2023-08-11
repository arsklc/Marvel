package com.kilica.marvelmobven.presentation.homepage

import com.kilica.marvelmobven.domain.model.Creator

data class CreatorsState(
    val shouldShowLoading : Boolean = true,
    val creators : List<Creator> = emptyList(),
    val error : String? = null
)

