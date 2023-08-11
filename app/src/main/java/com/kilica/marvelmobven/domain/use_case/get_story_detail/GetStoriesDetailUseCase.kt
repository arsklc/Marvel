package com.kilica.marvelmobven.domain.use_case.get_story_detail

import com.kilica.marvelmobven.domain.model.Story
import com.kilica.marvelmobven.domain.repository.StoryRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetStoryDetailUseCase @Inject constructor(private val repository: StoryRepository) {

    fun executeGetStoryDetail(id:String): Flow<Resource<Story>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getStoryById(id)))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        }
    }
}