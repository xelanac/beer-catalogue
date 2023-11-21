package com.xelanac.beer_catalogue.data.remote

import com.xelanac.beer_catalogue.data.remote.dto.BeerDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerApi {

    @GET("beers/random")
    suspend fun getRandomBeer(): List<BeerDto>

    @GET("beers/{id}")
    suspend fun getBeerDetail(@Path("id") id: Int): List<BeerDto>

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page")  pageCount: Int
    ): List<BeerDto>
}