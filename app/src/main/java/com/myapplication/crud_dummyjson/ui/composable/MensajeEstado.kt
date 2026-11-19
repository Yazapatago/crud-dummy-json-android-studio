package com.myapplication.crud_dummyjson.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MensajeEstado(
    texto: String,
    colorTexto: Color,
    colorFondo: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = texto,
        modifier = modifier
            .fillMaxWidth()
            .background(colorFondo, RoundedCornerShape(10.dp))
            .padding(12.dp),
        color = colorTexto,
        fontSize = 14.sp
    )
}