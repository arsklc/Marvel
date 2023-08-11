package com.kilica.marvelmobven.presentation.homepage

import com.kilica.marvelmobven.domain.model.Event


data class EventsState(
    val shouldShowLoading : Boolean = true,
    val events : List<Event> = emptyList(),
    val error : String? = null
)
