package com.example.groceryinventory.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.groceryinventory.domain.model.Product
import com.example.groceryinventory.ui.theme.PaddingValues.xlarge
import com.example.groceryinventory.ui.theme.SizeValues.SpacerHeight10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryScreen(
    products: List<Product>,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    onSortAscending: () -> Unit,
    onSortDescending: () -> Unit
) {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White)
                    .padding(xlarge)
            ) {
                SearchAndSortBar(
                    searchQuery = searchQuery,
                    onSearchChange = onSearchChange,
                    onSortAscending = onSortAscending,
                    onSortDescending = onSortDescending
                )

                Spacer(modifier = Modifier.height(SpacerHeight10))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(SpacerHeight10),
                    contentPadding = PaddingValues(bottom = xlarge)
                ) {
                    items(products) { item ->
                        GroceryCard(item)
                    }
                }
            }
        }
    )
}
