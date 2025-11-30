package com.example.groceryinventory.ui.compose

import CustomSearchTextField
import GreenOutlinedButton
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.groceryinventory.R
import com.example.groceryinventory.ui.theme.AppStrings
import com.example.groceryinventory.ui.theme.PaddingValues


@Composable
fun SearchAndSortBar(
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    onSortAscending: () -> Unit,
    onSortDescending: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
    ) {
        CustomSearchTextField(searchQuery, onSearchChange)
        Spacer(modifier = Modifier.width(PaddingValues.xs))

        GreenOutlinedButton(onClick = onSortAscending, AppStrings.asc, R.drawable.down_arrow)
        Spacer(modifier = Modifier.width(PaddingValues.xs))
        GreenOutlinedButton(onClick = onSortDescending, AppStrings.desc, R.drawable.up_arrow)

    }
}



@Preview(showBackground = true)
@Composable
fun SearchAndSortBarPreview() {
    val searchQueryState = remember { mutableStateOf("") }

    SearchAndSortBar(
        searchQuery = searchQueryState.value,
        onSearchChange = { newQuery -> searchQueryState.value = newQuery },
        onSortAscending = { },
        onSortDescending = { })
}


