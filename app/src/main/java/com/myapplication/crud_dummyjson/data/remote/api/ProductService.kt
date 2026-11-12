package com.myapplication.crud_dummyjson.data.remote.api

import com.myapplication.crud_dummyjson.data.remote.dto.product.PatchProduct
import com.myapplication.crud_dummyjson.data.remote.dto.product.Product
import com.myapplication.crud_dummyjson.data.remote.dto.product.ProductListResponse
import com.myapplication.crud_dummyjson.data.remote.dto.product.ProductX
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductService {
    @GET("products")
    suspend fun GetProduct(): ProductListResponse

    @GET("products/{id}")
    suspend fun GetProductById(
        @Path("id") id: Int
    ): Product

    @DELETE("products/{id}")
    suspend fun DeleteProductById(
        @Path("id") id: Int
    ): Product

    @PATCH("products/{id}")
    suspend fun PatchProductById(
        @Path("id") id: Int,
        @Body product: PatchProduct
    ): Product

    @PUT("products/{id}")
    suspend fun PutProduct(
        @Path("id") id: Int,
        @Body product: ProductX
    ): Product

    @POST("products/add")
    suspend fun AddProduct(
        @Body product: ProductX
    ): Product
}