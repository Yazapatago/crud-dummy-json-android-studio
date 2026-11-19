package com.myapplication.crud_dummyjson.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.ui.composable.BotonPrincipal
import com.myapplication.crud_dummyjson.ui.composable.Parrafo
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal

@Composable
fun EncabezadoListaSection(
    onNuevoProducto: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Parrafo(texto = "Elige un producto para ver más detalles o agrega uno nuevo.")
        Spacer(modifier = Modifier.height(14.dp))
        BotonPrincipal(
            texto = "+ Nuevo Producto",
            color = MoradoPrincipal,
            onClick = onNuevoProducto
        )
    }
}