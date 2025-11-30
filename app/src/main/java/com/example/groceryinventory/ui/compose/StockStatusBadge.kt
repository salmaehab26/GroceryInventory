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
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.LightGreen
import com.example.groceryinventory.ui.theme.Yellow

@Composable
fun StockStatusBadge(status: StockStatus) {
    val (color, text,image) = when (status) {
        StockStatus.CRITICAL -> Triple(Color.Red, "Critical", R.drawable.warning)
        StockStatus.WARNING -> Triple(Yellow, "Warning", R.drawable.caution)
        StockStatus.STABLE -> Triple(Green, "Stable", R.drawable.check_circle)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(LightGreen, RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 7.dp)
            .width(100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.warning),
            contentDescription = "Warning",
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Warning",
            color = Green,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

