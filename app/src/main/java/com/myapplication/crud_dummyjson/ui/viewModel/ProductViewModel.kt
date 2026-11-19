package com.myapplication.crud_dummyjson.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.crud_dummyjson.domain.model.ProductModel
import com.myapplication.crud_dummyjson.domain.useCase.CreateProductUseCase
import com.myapplication.crud_dummyjson.domain.useCase.DeleteProductUseCase
import com.myapplication.crud_dummyjson.domain.useCase.GetProducUseCase
import com.myapplication.crud_dummyjson.domain.useCase.UpdateProductUseCase
import com.myapplication.crud_dummyjson.ui.state.ProductUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductUseCase: GetProducUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductUIState())
    val uiState: StateFlow<ProductUIState> = _uiState.asStateFlow()

    init { loadProducts() }

    fun loadProducts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            runCatching { getProductUseCase() }
                .onSuccess { list -> _uiState.update { it.copy(isLoading = false, products = list) } }
                .onFailure { e -> _uiState.update { it.copy(isLoading = false, errorMessage = e.message ?: "No se pudieron cargar los productos") } }
        }
    }

    fun selectProduct(product: ProductModel?) { _uiState.update { it.copy(selectedProduct = product, errorMessage = null, successMessage = null) } }

    fun createProduct(product: ProductModel) {
        viewModelScope.launch {
            _uiState.update { it.copy(isSaving = true, errorMessage = null, successMessage = null) }
            runCatching { createProductUseCase(product) }
                .onSuccess { created ->
                    _uiState.update { it.copy(isSaving = false, products = listOf(created) + it.products, selectedProduct = null, successMessage = "Producto agregado correctamente") }
                }
                .onFailure { e -> _uiState.update { it.copy(isSaving = false, errorMessage = e.message ?: "No se pudo agregar el producto") } }
        }
    }

    fun updateProduct(product: ProductModel) {
        viewModelScope.launch {
            _uiState.update { it.copy(isSaving = true, errorMessage = null, successMessage = null) }
            runCatching { updateProductUseCase(product) }
                .onSuccess { updated ->
                    _uiState.update { state ->
                        state.copy(isSaving = false, products = state.products.map { if (it.id == updated.id) updated else it }, selectedProduct = null, successMessage = "Producto actualizado correctamente")
                    }
                }
                .onFailure { e -> _uiState.update { it.copy(isSaving = false, errorMessage = e.message ?: "No se pudo actualizar el producto") } }
        }
    }

    fun deleteProduct(product: ProductModel) {
        viewModelScope.launch {
            _uiState.update { it.copy(isSaving = true, errorMessage = null, successMessage = null) }
            runCatching { deleteProductUseCase(product.id) }
                .onSuccess {
                    _uiState.update { state -> state.copy(isSaving = false, products = state.products.filterNot { it.id == product.id }, successMessage = "Producto eliminado correctamente") }
                }
                .onFailure { e -> _uiState.update { it.copy(isSaving = false, errorMessage = e.message ?: "No se pudo eliminar el producto") } }
        }
    }
}