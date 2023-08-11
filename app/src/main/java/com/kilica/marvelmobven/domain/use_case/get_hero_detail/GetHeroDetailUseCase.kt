package com.kilica.marvelmobven.domain.use_case.get_hero_detail

import com.kilica.marvelmobven.domain.model.Hero
import com.kilica.marvelmobven.domain.repository.HeroRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetHeroDetailUseCase @Inject constructor(private val repository: HeroRepository) {

    fun executeGetHeroDetail(id:String): Flow<Resource<Hero>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getHeroById(id)))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        }
    }
}