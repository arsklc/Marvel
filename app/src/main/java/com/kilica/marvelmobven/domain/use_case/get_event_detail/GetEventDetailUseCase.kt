package com.kilica.marvelmobven.domain.use_case.get_event_detail


import com.kilica.marvelmobven.domain.model.Event
import com.kilica.marvelmobven.domain.repository.EventRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetEventDetailUseCase @Inject constructor(private val repository: EventRepository) {

    fun executeGetEventDetail(id:String): Flow<Resource<Event>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getEventById(id)))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        }
    }
}