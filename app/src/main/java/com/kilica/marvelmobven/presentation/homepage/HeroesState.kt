package com.kilica.marvelmobven.presentation.homepage

import com.kilica.marvelmobven.domain.model.Hero

data class HeroesState(
    val shouldShowLoading : Boolean = true,
    val heroes : List<Hero> = emptyList(),
    val error : String? = null
)
