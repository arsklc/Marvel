package com.kilica.marvelmobven.domain.use_case.get_heroes

import com.kilica.marvelmobven.domain.model.Hero
import com.kilica.marvelmobven.domain.repository.HeroRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.net.UnknownHostException
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(
    private val repository: HeroRepository
) {

    fun executeGetHeroes(offset: Int): Flow<Resource<List<Hero>>> = flow {
        try {
            emit(Resource.Loading())
            val heroList = repository.getAllHeroes(offset = offset)
            emit(Resource.Success(heroList))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        } catch (e: UnknownHostException) {
            emit(Resource.Error(message = e.message ?: ""))
        }

    }
}
