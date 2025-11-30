package com.example.groceryinventory.ui.compose

import CustomSearchTextField
import GreenOutlinedButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.groceryinventory.R
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.PaddingValues
import com.example.groceryinventory.ui.theme.SizeValues


@Composable
fun SearchAndSortBar(
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    onSortAscending: () -> Unit,
    onSortDescending: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
    ) {
        CustomSearchTextField(searchQuery, onSearchChange)
        Spacer(modifier = Modifier.width(PaddingValues.xs))
        Box {
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Sort",
                modifier = Modifier
                    .size(SizeValues.iconLarge)
                    .clickable { menuExpanded = true }
            )

            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false },

            ) {
                DropdownMenuItem(
                    text = { Text("Sort Ascending", color = Green) },
                    onClick = {
                        menuExpanded = false
                        onSortAscending()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Sort Descending", color = Green)},
                    onClick = {
                        menuExpanded = false
                        onSortDescending()
                    }
                )
            }
        }
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


