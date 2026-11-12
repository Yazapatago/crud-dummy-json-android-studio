package com.myapplication.crud_dummyjson.data.remote.dto.product

data class ProductListResponse(
    val product: List<Product> = emptyList()
)
