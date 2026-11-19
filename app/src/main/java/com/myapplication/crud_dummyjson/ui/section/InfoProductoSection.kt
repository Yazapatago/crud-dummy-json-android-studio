package com.myapplication.crud_dummyjson.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.myapplication.crud_dummyjson.domain.model.ProductModel
import com.myapplication.crud_dummyjson.ui.composable.Parrafo
import com.myapplication.crud_dummyjson.ui.composable.Titulo
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal

@Composable
fun InfoProductoSection(
    producto: ProductModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AsyncImage(
            model = producto.imageUrl,
            contentDescription = producto.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Titulo(texto = producto.title)
        Spacer(modifier = Modifier.height(4.dp))
        Parrafo(texto = producto.category)
        Spacer(modifier = Modifier.height(10.dp))
        Titulo(texto = "\$${producto.price}", color = MoradoPrincipal, tamano = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Titulo(texto = "Descripción", tamano = 18.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Parrafo(texto = producto.description)
    }
}