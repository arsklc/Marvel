package com.kilica.marvelmobven.domain.repository

import com.kilica.marvelmobven.domain.model.Event

interface EventRepository{
suspend fun getAllEvents(offset:Int):List<Event>

suspend fun getEventById(id:String): Event
}