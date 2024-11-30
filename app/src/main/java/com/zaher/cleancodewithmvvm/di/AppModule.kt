package com.zaher.cleancodewithmvvm.di

import com.zaher.cleancodewithmvvm.data.ApiClient
import com.zaher.cleancodewithmvvm.data.ApiService
import com.zaher.cleancodewithmvvm.data.repository.ItemRepositoryImpl
import com.zaher.cleancodewithmvvm.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ApiService = ApiClient.apiService

    @Provides
    fun provideItemRepository(apiService: ApiService): ItemRepository {
        return ItemRepositoryImpl(apiService)
    }
}
