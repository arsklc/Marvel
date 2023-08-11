package com.kilica.marvelmobven.presentation.detail

import com.kilica.marvelmobven.domain.model.Creator

data class CreatorDetailState(
    val isLoading : Boolean = false,
    val creator : Creator? = null,
    val error : String = ""
)
