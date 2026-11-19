package com.myapplication.crud_dummyjson.domain.useCase

import com.myapplication.crud_dummyjson.domain.model.ProductModel
import com.myapplication.crud_dummyjson.domain.repository.ProductRepository
import javax.inject.Inject

class GetProducUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<ProductModel> = repository.getProducts()
    suspend fun byId(id: Int): ProductModel = repository.getProductById(id)
}