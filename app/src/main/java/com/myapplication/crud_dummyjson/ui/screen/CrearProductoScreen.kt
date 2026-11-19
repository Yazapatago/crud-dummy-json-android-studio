package com.myapplication.crud_dummyjson.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.ui.composable.BarraSuperior
import com.myapplication.crud_dummyjson.ui.section.FormularioProductoSection
import com.myapplication.crud_dummyjson.ui.theme.FondoApp
import com.myapplication.crud_dummyjson.ui.viewModel.ProductViewModel

@Composable
fun CrearProductoScreen(
    viewModel: ProductViewModel,
    onVolver: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoApp)
    ) {
        BarraSuperior(titulo = "Nuevo Producto", onVolver = onVolver)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            FormularioProductoSection(
                producto = null,
                textoBoton = "Agregar",
                onGuardar = { producto ->
                    viewModel.createProduct(producto)
                    onVolver()
                },
                onCancelar = onVolver
            )
        }
    }
}