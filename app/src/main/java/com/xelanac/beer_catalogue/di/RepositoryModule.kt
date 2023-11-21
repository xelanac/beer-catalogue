package com.xelanac.beer_catalogue.di

import com.xelanac.beer_catalogue.data.remote.BeerApi
import com.xelanac.beer_catalogue.data.repository.BeerRepositoryImpl
import com.xelanac.beer_catalogue.domain.repository.BeerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinRepository(api: BeerApi): BeerRepository {
        return BeerRepositoryImpl(api)
    }
}