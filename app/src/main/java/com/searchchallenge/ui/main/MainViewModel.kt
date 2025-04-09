package com.searchchallenge.ui.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.searchchallenge.ui.composable.model.Product
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(
) : ViewModel() {

    private val _searchProductData = mutableStateOf<List<Product>>(emptyList())
    val searchProductData: State<List<Product>> = _searchProductData

    fun searchProducts(query: String) {
        viewModelScope.launch {
            try {

            } catch (e: HttpException) {
                Log.e("error", e.message ?: "ERROR")
            }
        }
    }
}
