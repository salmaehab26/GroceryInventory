package com.example.groceryinventory.domain.model

import android.graphics.Color
import com.example.groceryinventory.R
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.Red
import com.example.groceryinventory.ui.theme.Yellow

enum class StockStatus(
    val color: androidx.compose.ui.graphics.Color,
    val displayText: String,
    val image: Int
) {
    CRITICAL(
    color = Red,
    displayText = "Critical",
        image = R.drawable.warning
    ),

    WARNING(
    color = Yellow,
    displayText = "Warning",
        image = R.drawable.caution
    ),

    STABLE(
    color = Green,
    displayText = "Stable",
        image = R.drawable.check_circle
    )
}