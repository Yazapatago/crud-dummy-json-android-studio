package com.myapplication.crud_dummyjson.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.ui.composable.BotonPrincipal
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal
import com.myapplication.crud_dummyjson.ui.theme.RojoPrincipal

@Composable
fun AccionesProductoSection(
    onEditar: () -> Unit,
    onEliminar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BotonPrincipal(texto = "Editar", color = MoradoPrincipal, onClick = onEditar)
        BotonPrincipal(texto = "Eliminar", color = RojoPrincipal, onClick = onEliminar)
    }
}