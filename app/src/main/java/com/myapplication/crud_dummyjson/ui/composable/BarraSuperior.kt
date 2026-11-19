package com.myapplication.crud_dummyjson.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal
import com.myapplication.crud_dummyjson.ui.theme.TextoOscuro

@Composable
fun BarraSuperior(
    titulo: String,
    onVolver: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(onClick = onVolver) {
            Text(text = "← Volver", color = MoradoPrincipal, fontSize = 15.sp)
        }
        Text(
            text = titulo,
            modifier = Modifier.weight(1f),
            color = TextoOscuro,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}