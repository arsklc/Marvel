package com.kilica.marvelmobven.domain.use_case.get_events

import com.kilica.marvelmobven.domain.model.Event
import com.kilica.marvelmobven.domain.repository.EventRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.net.UnknownHostException
import javax.inject.Inject

class GetEventUseCase @Inject constructor(
    private val repository: EventRepository
) {

    fun executeGetEvents(offset: Int): Flow<Resource<List<Event>>> = flow {
        try {
            emit(Resource.Loading())
            val eventList = repository.getAllEvents(offset = offset)
            emit(Resource.Success(eventList))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        } catch (e: UnknownHostException) {
            emit(Resource.Error(message = e.message ?: ""))
        }
    }
}