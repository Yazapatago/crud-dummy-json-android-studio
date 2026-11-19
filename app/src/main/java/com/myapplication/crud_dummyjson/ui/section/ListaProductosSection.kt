package com.myapplication.crud_dummyjson.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.domain.model.ProductModel
import com.myapplication.crud_dummyjson.ui.composable.ProductoItem

@Composable
fun ListaProductosSection(
    productos: List<ProductModel>,
    onVerDetalle: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        productos.forEach { producto ->
            ProductoItem(
                titulo = producto.title,
                categoria = producto.category,
                precio = producto.price,
                imagenUrl = producto.imageUrl,
                onVerDetalle = { onVerDetalle(producto.id) }
            )
        }
    }
}