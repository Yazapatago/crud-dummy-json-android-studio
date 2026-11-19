package com.myapplication.crud_dummyjson.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.ui.composable.BarraSuperior
import com.myapplication.crud_dummyjson.ui.composable.DialogoEliminar
import com.myapplication.crud_dummyjson.ui.composable.Parrafo
import com.myapplication.crud_dummyjson.ui.section.AccionesProductoSection
import com.myapplication.crud_dummyjson.ui.section.InfoProductoSection
import com.myapplication.crud_dummyjson.ui.theme.FondoApp
import com.myapplication.crud_dummyjson.ui.viewModel.ProductViewModel

@Composable
fun DetalleProductoScreen(
    id: Int,
    viewModel: ProductViewModel,
    onVolver: () -> Unit,
    onEditar: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val producto = uiState.products.find { it.id == id }
    var mostrarDialogo by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoApp)
    ) {
        BarraSuperior(titulo = "Detalle", onVolver = onVolver)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            if (producto != null) {
                InfoProductoSection(producto = producto)
                Spacer(modifier = Modifier.height(24.dp))
                AccionesProductoSection(
                    onEditar = onEditar,
                    onEliminar = { mostrarDialogo = true }
                )
            } else {
                Parrafo(texto = "Producto no encontrado.")
            }
        }
    }

    if (mostrarDialogo && producto != null) {
        DialogoEliminar(
            nombreProducto = producto.title,
            onConfirmar = {
                mostrarDialogo = false
                viewModel.deleteProduct(producto)
                onVolver()
            },
            onCancelar = { mostrarDialogo = false }
        )
    }
}