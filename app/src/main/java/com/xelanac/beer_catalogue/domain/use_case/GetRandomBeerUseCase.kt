package com.xelanac.beer_catalogue.domain.use_case

import com.xelanac.beer_catalogue.common.Resource
import com.xelanac.beer_catalogue.data.remote.dto.toBeer
import com.xelanac.beer_catalogue.domain.model.Beer
import com.xelanac.beer_catalogue.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomBeerUseCase @Inject constructor(
    private val repository: BeerRepository
){
    operator fun invoke(): Flow<Resource<Beer>> = flow {
        try {
            emit(Resource.Loading())
            val beer = repository.getRandomBeer().first().toBeer()
            emit(Resource.Success(beer))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}