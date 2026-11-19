package com.myapplication.crud_dummyjson.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myapplication.crud_dummyjson.ui.section.BienvenidaSection
import com.myapplication.crud_dummyjson.ui.theme.FondoApp

@Composable
fun InicioScreen(
    onVerProductos: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoApp)
            .padding(24.dp)
    ) {
        BienvenidaSection(onVerProductos = onVerProductos)
    }
}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    InicioScreen(onVerProductos = {})
}