package com.example.groceryinventory.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.groceryinventory.ui.theme.AppStrings
import com.example.groceryinventory.ui.theme.AppStrings.daysOfWeek
import com.example.groceryinventory.ui.theme.FontSizes
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.LightGreen
import com.example.groceryinventory.ui.theme.PaddingValues
import com.example.groceryinventory.ui.theme.SizeValues

@Composable
fun ConsumptionLineChart(
    data: List<Int>,
    maxChartHeight: Dp = SizeValues.maxChartHeight
) {
    val maxValue = (data.maxOrNull() ?: 1).toFloat()

    Row(verticalAlignment = Alignment.Bottom) {

        data.forEachIndexed { idx, value ->

            val scaled = value.toFloat() / maxValue

            val heightRatio = scaled.coerceIn(0f, 1f)

            val barHeight = heightRatio * maxChartHeight.value

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                Text(
                    "$value",
                    fontSize = FontSizes.small,
                    color = Green
                )

                Box(
                    modifier = Modifier
                        .width(PaddingValues.medium)
                        .height(barHeight.dp)
                        .background(LightGreen, RoundedCornerShape(4.dp))
                )

                Text(
                    text = daysOfWeek[idx],
                    fontSize = FontSizes.small,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(SizeValues.verySmall))
        }
    }
}