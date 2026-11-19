package com.myapplication.crud_dummyjson.domain.model

import java.sql.Struct

data class ProductModel(
    val id : Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val imageUrl: String = ""
)
