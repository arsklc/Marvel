package com.kilica.marvelmobven.data.repository

import com.kilica.marvelmobven.data.datasource.EventApiDataSource
import com.kilica.marvelmobven.data.mapper.Mapper.mapToEventList
import com.kilica.marvelmobven.data.mapper.Mapper.toEvent
import com.kilica.marvelmobven.domain.model.Event
import com.kilica.marvelmobven.domain.repository.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val dataSource: EventApiDataSource
) : EventRepository {
    override suspend fun getAllEvents(offset: Int): List<Event> {
        return dataSource.getEvents(offset = offset.toString()).mapToEventList()
    }

    override suspend fun getEventById(id: String): Event {
        return dataSource.getEventDetails(id).toEvent()
    }
}