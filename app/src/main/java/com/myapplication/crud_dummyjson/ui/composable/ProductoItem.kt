package com.myapplication.crud_dummyjson.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.myapplication.crud_dummyjson.ui.theme.MoradoClaro
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal
import com.myapplication.crud_dummyjson.ui.theme.TextoGris
import com.myapplication.crud_dummyjson.ui.theme.TextoOscuro

@Composable
fun ProductoItem(
    titulo: String,
    categoria: String,
    precio: Double,
    imagenUrl: String,
    onVerDetalle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = imagenUrl,
                contentDescription = titulo,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MoradoClaro)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = titulo,
                    color = TextoOscuro,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = categoria, color = TextoGris, fontSize = 13.sp)
                Text(
                    text = "\$$precio",
                    color = MoradoPrincipal,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            OutlinedButton(
                onClick = onVerDetalle,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, MoradoPrincipal),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(text = "Ver Detalle", color = MoradoPrincipal, fontSize = 13.sp)
            }
        }
    }
}