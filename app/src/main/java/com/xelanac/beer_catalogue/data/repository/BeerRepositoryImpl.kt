package com.xelanac.beer_catalogue.data.repository

import com.xelanac.beer_catalogue.data.remote.BeerApi
import com.xelanac.beer_catalogue.data.remote.dto.BeerDto
import com.xelanac.beer_catalogue.domain.repository.BeerRepository
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(
    private val api: BeerApi
): BeerRepository {
    override suspend fun getRandomBeer(): List<BeerDto> {
        return api.getRandomBeer()
    }

    override suspend fun getBeerDetail(beerId: Int): List<BeerDto> {
        return api.getBeerDetail(beerId)
    }

    override suspend fun getBeers(page: Int, pageCount: Int): List<BeerDto> {
        return api.getBeers(
            page = page,
            pageCount = pageCount
        )
    }
}