package com.myapplication.crud_dummyjson.data.remote.dto.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @param:Json(name = "limit")
    val limit: Int,
    @param:Json(name = "products")
    val products: List<ProductX>,
    @param:Json(name = "skip")
    val skip: Int,
    @param:Json(name = "total")
    val total: Int
)