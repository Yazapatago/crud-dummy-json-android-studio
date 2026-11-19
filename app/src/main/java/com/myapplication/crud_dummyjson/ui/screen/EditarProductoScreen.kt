package com.myapplication.crud_dummyjson.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.ui.composable.BarraSuperior
import com.myapplication.crud_dummyjson.ui.composable.Parrafo
import com.myapplication.crud_dummyjson.ui.section.FormularioProductoSection
import com.myapplication.crud_dummyjson.ui.theme.FondoApp
import com.myapplication.crud_dummyjson.ui.viewModel.ProductViewModel

@Composable
fun EditarProductoScreen(
    id: Int,
    viewModel: ProductViewModel,
    onVolver: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val producto = uiState.products.find { it.id == id }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoApp)
    ) {
        BarraSuperior(titulo = "Editar Producto", onVolver = onVolver)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            if (producto != null) {
                FormularioProductoSection(
                    producto = producto,
                    textoBoton = "Actualizar",
                    onGuardar = { productoEditado ->
                        viewModel.updateProduct(productoEditado)
                        onVolver()
                    },
                    onCancelar = onVolver
                )
            } else {
                Parrafo(texto = "Producto no encontrado.")
            }
        }
    }
}