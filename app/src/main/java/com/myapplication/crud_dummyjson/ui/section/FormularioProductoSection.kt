package com.myapplication.crud_dummyjson.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.domain.model.ProductModel
import com.myapplication.crud_dummyjson.ui.composable.BotonPrincipal
import com.myapplication.crud_dummyjson.ui.composable.CampoTexto
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal
import com.myapplication.crud_dummyjson.ui.theme.TextoGris

@Composable
fun FormularioProductoSection(
    producto: ProductModel?,
    textoBoton: String,
    onGuardar: (ProductModel) -> Unit,
    onCancelar: () -> Unit,
    modifier: Modifier = Modifier
) {
    var titulo by remember { mutableStateOf(producto?.title ?: "") }
    var descripcion by remember { mutableStateOf(producto?.description ?: "") }
    var categoria by remember { mutableStateOf(producto?.category ?: "") }
    var precio by remember { mutableStateOf(producto?.price?.toString() ?: "") }

    val precioNumero = precio.toDoubleOrNull()
    val formularioValido = titulo.isNotBlank() && categoria.isNotBlank() && precioNumero != null

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CampoTexto(valor = titulo, onValorChange = { titulo = it }, etiqueta = "Título")
            CampoTexto(valor = descripcion, onValorChange = { descripcion = it }, etiqueta = "Descripción")
            CampoTexto(valor = categoria, onValorChange = { categoria = it }, etiqueta = "Categoría")
            CampoTexto(
                valor = precio,
                onValorChange = { precio = it },
                etiqueta = "Precio",
                teclado = KeyboardType.Decimal
            )
            BotonPrincipal(
                texto = textoBoton,
                color = MoradoPrincipal,
                habilitado = formularioValido,
                onClick = {
                    onGuardar(
                        ProductModel(
                            id = producto?.id ?: 0,
                            title = titulo,
                            description = descripcion,
                            category = categoria,
                            price = precioNumero ?: 0.0,
                            imageUrl = producto?.imageUrl ?: ""
                        )
                    )
                }
            )
            BotonPrincipal(texto = "Cancelar", color = TextoGris, onClick = onCancelar)
        }
    }
}