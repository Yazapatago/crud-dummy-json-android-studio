package com.myapplication.crud_dummyjson.navigation

import kotlinx.serialization.Serializable

@Serializable
data object InicioRoute

@Serializable
data object ListaProductosRoute

@Serializable
data class DetalleProductoRoute(val id: Int)

@Serializable
data object CrearProductoRoute

@Serializable
data class EditarProductoRoute(val id: Int)