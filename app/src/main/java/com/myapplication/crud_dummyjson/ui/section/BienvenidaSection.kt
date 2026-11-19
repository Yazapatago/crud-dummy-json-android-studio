package com.myapplication.crud_dummyjson.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.crud_dummyjson.ui.composable.BotonPrincipal
import com.myapplication.crud_dummyjson.ui.composable.Parrafo
import com.myapplication.crud_dummyjson.ui.composable.Titulo
import com.myapplication.crud_dummyjson.ui.theme.MoradoClaro
import com.myapplication.crud_dummyjson.ui.theme.MoradoPrincipal

@Composable
fun BienvenidaSection(
    onVerProductos: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(170.dp)
                    .background(MoradoClaro, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Titulo(texto = "CRUD", color = MoradoPrincipal, tamano = 36.sp)
            }
            Spacer(modifier = Modifier.height(32.dp))
            Titulo(
                texto = "CRUD DummyJSON",
                tamano = 28.sp,
                alineacion = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Parrafo(
                texto = "Crea, consulta, edita y elimina productos usando la API de DummyJSON.",
                alineacion = TextAlign.Center
            )
        }
        BotonPrincipal(
            texto = "Ver Productos",
            color = MoradoPrincipal,
            onClick = onVerProductos
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}