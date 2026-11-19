package com.myapplication.crud_dummyjson.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.ui.composable.BarraSuperior
import com.myapplication.crud_dummyjson.ui.composable.MensajeEstado
import com.myapplication.crud_dummyjson.ui.section.EncabezadoListaSection
import com.myapplication.crud_dummyjson.ui.section.ListaProductosSection
import com.myapplication.crud_dummyjson.ui.theme.FondoApp
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal
import com.myapplication.crud_dummyjson.ui.theme.RojoClaro
import com.myapplication.crud_dummyjson.ui.theme.RojoPrincipal
import com.myapplication.crud_dummyjson.ui.theme.VerdeClaro
import com.myapplication.crud_dummyjson.ui.theme.VerdePrincipal
import com.myapplication.crud_dummyjson.ui.viewModel.ProductViewModel

@Composable
fun ListaProductosScreen(
    viewModel: ProductViewModel,
    onVolver: () -> Unit,
    onVerDetalle: (Int) -> Unit,
    onNuevoProducto: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoApp)
    ) {
        BarraSuperior(titulo = "Productos", onVolver = onVolver)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            EncabezadoListaSection(onNuevoProducto = onNuevoProducto)
            Spacer(modifier = Modifier.height(16.dp))

            uiState.successMessage?.let { mensaje ->
                MensajeEstado(texto = mensaje, colorTexto = VerdePrincipal, colorFondo = VerdeClaro)
                Spacer(modifier = Modifier.height(16.dp))
            }
            uiState.errorMessage?.let { mensaje ->
                MensajeEstado(texto = mensaje, colorTexto = RojoPrincipal, colorFondo = RojoClaro)
                Spacer(modifier = Modifier.height(16.dp))
            }

            if (uiState.isLoading) {
                CircularProgressIndicator(
                    color = MoradoPrincipal,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                ListaProductosSection(
                    productos = uiState.products,
                    onVerDetalle = onVerDetalle
                )
            }
        }
    }
}