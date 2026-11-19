package com.myapplication.crud_dummyjson.ui.composable

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.myapplication.crud_dummyjson.ui.theme.RojoPrincipal
import com.myapplication.crud_dummyjson.ui.theme.TextoGris

@Composable
fun DialogoEliminar(
    nombreProducto: String,
    onConfirmar: () -> Unit,
    onCancelar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCancelar,
        title = { Text(text = "Eliminar producto") },
        text = { Text(text = "¿Seguro que deseas eliminar \"$nombreProducto\"?") },
        confirmButton = {
            TextButton(onClick = onConfirmar) {
                Text(text = "Eliminar", color = RojoPrincipal)
            }
        },
        dismissButton = {
            TextButton(onClick = onCancelar) {
                Text(text = "Cancelar", color = TextoGris)
            }
        }
    )
}