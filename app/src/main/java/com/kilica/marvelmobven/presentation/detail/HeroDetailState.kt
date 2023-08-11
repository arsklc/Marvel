package com.kilica.marvelmobven.presentation.detail


import com.kilica.marvelmobven.domain.model.Hero

data class HeroDetailState(
    val isLoading : Boolean = false,
    val hero : Hero? = null,
    val error : String = ""
)
