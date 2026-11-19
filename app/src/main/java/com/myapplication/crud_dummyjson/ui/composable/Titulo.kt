package com.myapplication.crud_dummyjson.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.myapplication.crud_dummyjson.ui.theme.TextoOscuro

@Composable
fun Titulo(
    texto: String,
    modifier: Modifier = Modifier,
    color: Color = TextoOscuro,
    tamano: TextUnit = 24.sp,
    alineacion: TextAlign = TextAlign.Start
) {
    Text(
        text = texto,
        modifier = modifier,
        color = color,
        fontSize = tamano,
        fontWeight = FontWeight.Bold,
        textAlign = alineacion
    )
}