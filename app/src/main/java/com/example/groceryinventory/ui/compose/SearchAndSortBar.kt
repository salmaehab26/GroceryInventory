package com.example.groceryinventory.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.common.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceryinventory.R
import com.example.groceryinventory.ui.theme.FontSizes.medium
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.PaddingValues.small

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
        Spacer(modifier = Modifier.width(8.dp))

        GreenOutlinedButton(onClick = onSortAscending, "ASC", R.drawable.down_arrow)
        Spacer(modifier = Modifier.width(4.dp))
        GreenOutlinedButton(onClick = onSortDescending, "DESC", R.drawable.up_arrow)

    }
}

@Composable
fun GreenOutlinedButton(
    onClick: () -> Unit,
    text: String,
    image: Int
) {
    val greenColor = Color(0xFF4CAF50)

    Box(
        modifier = Modifier
            .width(80.dp)
            .border(
                BorderStroke(1.dp, greenColor),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Arrow",
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = text,
                color = greenColor,
                fontSize = medium,
            )
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


@Composable
fun CustomSearchTextField(
    searchQuery: String, onSearchChange: (String) -> Unit
) {
    val greenColor = Green
    val greenLight = Green.copy(alpha = 0.2F)

    TextField(
        value = searchQuery,
        onValueChange = onSearchChange,
        singleLine = true,
        placeholder = { Text("Search groceries…") },
        modifier = Modifier
            .height(50.dp)
            .width(200.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                tint = greenColor,
                modifier = Modifier.size(20.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = greenColor,
            focusedLeadingIconColor = greenColor,
            unfocusedLeadingIconColor = greenColor.copy(alpha = 0.7f),
            focusedPlaceholderColor = greenColor.copy(alpha = 0.7f),
            unfocusedPlaceholderColor = greenColor.copy(alpha = 0.7f),
            focusedContainerColor = greenLight,
            unfocusedContainerColor = greenLight,
            cursorColor = greenLight,

            ),
        shape = RoundedCornerShape(10.dp),
    )

}