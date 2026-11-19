package com.myapplication.crud_dummyjson.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.myapplication.crud_dummyjson.ui.theme.TextoGris

@Composable
fun Parrafo(
    texto: String,
    modifier: Modifier = Modifier,
    color: Color = TextoGris,
    alineacion: TextAlign = TextAlign.Start
) {
    Text(
        text = texto,
        modifier = modifier,
        color = color,
        fontSize = 15.sp,
        lineHeight = 22.sp,
        textAlign = alineacion
    )
}