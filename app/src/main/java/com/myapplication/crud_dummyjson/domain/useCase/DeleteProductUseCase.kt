package com.myapplication.crud_dummyjson.domain.useCase

import com.myapplication.crud_dummyjson.domain.repository.ProductRepository
import javax.inject.Inject

class DeleteProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Boolean = repository.deleteProduct(id)
}