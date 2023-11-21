package com.xelanac.beer_catalogue.domain.repository

import com.xelanac.beer_catalogue.data.remote.dto.BeerDto

interface BeerRepository {
    suspend fun getRandomBeer(): List<BeerDto>

    suspend fun getBeerDetail(beerId: Int): List<BeerDto>

    suspend fun getBeers(page: Int, pageCount: Int): List<BeerDto>
}