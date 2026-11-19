package com.myapplication.crud_dummyjson.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.myapplication.crud_dummyjson.ui.screen.CrearProductoScreen
import com.myapplication.crud_dummyjson.ui.screen.DetalleProductoScreen
import com.myapplication.crud_dummyjson.ui.screen.EditarProductoScreen
import com.myapplication.crud_dummyjson.ui.screen.InicioScreen
import com.myapplication.crud_dummyjson.ui.screen.ListaProductosScreen
import com.myapplication.crud_dummyjson.ui.viewModel.ProductViewModel

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val viewModel: ProductViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = InicioRoute,
        modifier = modifier
    ) {

        composable<InicioRoute> {
            InicioScreen(
                onVerProductos = { navController.navigate(ListaProductosRoute) }
            )
        }

        composable<ListaProductosRoute> {
            ListaProductosScreen(
                viewModel = viewModel,
                onVolver = { navController.popBackStack() },
                onVerDetalle = { id -> navController.navigate(DetalleProductoRoute(id)) },
                onNuevoProducto = { navController.navigate(CrearProductoRoute) }
            )
        }

        composable<DetalleProductoRoute> { backStackEntry ->
            val ruta = backStackEntry.toRoute<DetalleProductoRoute>()
            DetalleProductoScreen(
                id = ruta.id,
                viewModel = viewModel,
                onVolver = { navController.popBackStack() },
                onEditar = { navController.navigate(EditarProductoRoute(ruta.id)) }
            )
        }

        composable<CrearProductoRoute> {
            CrearProductoScreen(
                viewModel = viewModel,
                onVolver = { navController.popBackStack() }
            )
        }

        composable<EditarProductoRoute> { backStackEntry ->
            val ruta = backStackEntry.toRoute<EditarProductoRoute>()
            EditarProductoScreen(
                id = ruta.id,
                viewModel = viewModel,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}