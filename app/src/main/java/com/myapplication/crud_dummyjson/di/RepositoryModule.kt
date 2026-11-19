package com.myapplication.crud_dummyjson.di

import com.myapplication.crud_dummyjson.data.repository.ProductRepositoryImpl
import com.myapplication.crud_dummyjson.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        iml: ProductRepositoryImpl
    ): ProductRepository
}