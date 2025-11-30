package com.example.groceryinventory.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryinventory.R
import com.example.groceryinventory.domain.model.StockStatus
import com.example.groceryinventory.ui.theme.AppStrings
import com.example.groceryinventory.ui.theme.BadgeSizes
import com.example.groceryinventory.ui.theme.FontSizes
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.LightGreen
import com.example.groceryinventory.ui.theme.Yellow

@Composable
fun StockStatusBadge(status: StockStatus) {

    val (color, text, image) = when (status) {
        StockStatus.CRITICAL -> Triple(Color.Red, AppStrings.critical, R.drawable.warning)
        StockStatus.WARNING -> Triple(Yellow, AppStrings.warning, R.drawable.caution)
        StockStatus.STABLE -> Triple(Green, AppStrings.stable, R.drawable.check_circle)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                LightGreen,
                RoundedCornerShape(BadgeSizes.badgeRadius)
            )
            .padding(
                horizontal = BadgeSizes.badgePaddingHorizontal,
                vertical = BadgeSizes.badgePaddingVertical
            )
            .width(BadgeSizes.badgeWidth)
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = text,
            modifier = Modifier.size(BadgeSizes.iconSize)
        )

        Spacer(modifier = Modifier.width(BadgeSizes.spacerSmall))

        Text(
            text = text,
            color = color,
            fontWeight = FontWeight.Bold,
            fontSize = FontSizes.medium
        )
    }
}


