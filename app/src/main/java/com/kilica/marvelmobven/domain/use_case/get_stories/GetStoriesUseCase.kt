package com.kilica.marvelmobven.domain.use_case.get_stories

import com.kilica.marvelmobven.domain.model.Story
import com.kilica.marvelmobven.domain.repository.StoryRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.net.UnknownHostException
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(
    private val repository: StoryRepository
) {

    fun executeGetStories(offset: Int): Flow<Resource<List<Story>>> = flow {
        try {
            emit(Resource.Loading())
            val storiesList = repository.getAllStories(offset = offset)
            emit(Resource.Success(storiesList))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        } catch (e: UnknownHostException) {
            emit(Resource.Error(message = e.message ?: ""))
        }
    }
}