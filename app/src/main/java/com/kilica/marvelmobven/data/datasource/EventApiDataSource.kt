package com.kilica.marvelmobven.data.datasource

import com.kilica.marvelmobven.data.model.event.EventsDTO
import com.kilica.marvelmobven.network.api.EventAPI
import com.kilica.marvelmobven.util.Constants
import javax.inject.Inject

class EventApiDataSource @Inject constructor(
    private val api: EventAPI
) {
    suspend fun getEvents(offset: String): EventsDTO {
        return api.getAllEvents(
            offset = offset,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }

    suspend fun getEventDetails(eventId: String): EventsDTO {
        return api.getEventById(
            eventId = eventId,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }
}