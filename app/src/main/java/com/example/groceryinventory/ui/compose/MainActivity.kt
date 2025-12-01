package com.example.groceryinventory.ui.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.groceryinventory.ui.viewModel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val viewModel: ProductViewModel = hiltViewModel()
            val products by viewModel.products.collectAsState()
            var query by remember { mutableStateOf("") }
            Log.d("MainActivity", "Products: $products")
            GroceryScreen(
                products = products,
                searchQuery = query,
                onSearchChange = {
                    query = it
                    viewModel.onSearchQueryChanged(it)
                },
                onSortAscending = {
                    viewModel.onSortAscending()
                },
                onSortDescending = {
                    viewModel.onSortDescending()
                }
            )
        }
    }
}