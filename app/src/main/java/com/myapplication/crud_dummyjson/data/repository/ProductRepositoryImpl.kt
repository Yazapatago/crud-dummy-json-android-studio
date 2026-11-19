package com.myapplication.crud_dummyjson.data.repository

import com.myapplication.crud_dummyjson.data.mapper.toDomain
import com.myapplication.crud_dummyjson.data.remote.api.ProductService
import com.myapplication.crud_dummyjson.data.remote.dto.product.UpdateProductRequest
import com.myapplication.crud_dummyjson.domain.model.ProductModel
import com.myapplication.crud_dummyjson.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductService
) : ProductRepository {

    override suspend fun getProducts(): List<ProductModel> =
        api.GetProduct().products.map { it.toDomain() }

    override suspend fun getProductById(id: Int): ProductModel =
        api.GetProductById(id).toDomain()

    override suspend fun createProduct(product: ProductModel): ProductModel =
        api.AddProduct(product.toRequest()).toDomain()

    override suspend fun updateProduct(product: ProductModel): ProductModel =
        api.PutProduct(product.id, product.toRequest()).toDomain()

    override suspend fun deleteProduct(id: Int): Boolean {
        api.DeleteProductById(id)
        return true
    }

    private fun ProductModel.toRequest() = UpdateProductRequest(
        title = title,
        description = description,
        category = category,
        price = price
    )
}