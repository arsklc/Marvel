package com.kilica.marvelmobven.presentation.detail

import com.kilica.marvelmobven.domain.model.Event

data class EventDetailState(
    val isLoading : Boolean = false,
    val event : Event? = null,
    val error : String = ""
)
