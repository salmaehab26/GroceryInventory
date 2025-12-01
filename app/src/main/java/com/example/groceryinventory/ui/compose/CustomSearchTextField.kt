package com.example.groceryinventory.ui.compose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.common.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.groceryinventory.R
import com.example.groceryinventory.ui.theme.AppStrings.searchPlaceholder
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.RadiusValues
import com.example.groceryinventory.ui.theme.SizeValues
import com.example.groceryinventory.ui.theme.SizeValues.height50
import com.example.groceryinventory.ui.theme.SizeValues.width350

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
        placeholder = { Text(searchPlaceholder) },
        modifier = Modifier
            .height(height50)
            .width(width350),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = searchPlaceholder,
                tint = greenColor,
                modifier = Modifier.size(SizeValues.small)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = greenColor,
            focusedLeadingIconColor = greenColor,
            unfocusedIndicatorColor = greenColor,
            disabledContainerColor = Transparent,
            unfocusedSupportingTextColor =Transparent ,
            unfocusedLeadingIconColor = Transparent,
            focusedPlaceholderColor = Transparent,
            unfocusedPlaceholderColor = greenColor,
            focusedContainerColor = Transparent,
            unfocusedContainerColor = Transparent,
            cursorColor = greenLight,

            ),
        shape = RoundedCornerShape(RadiusValues.medium),
    )

}