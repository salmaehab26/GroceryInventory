package com.example.groceryinventory.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.groceryinventory.R
import com.example.groceryinventory.domain.model.Product
import com.example.groceryinventory.domain.model.StockStatus
import com.example.groceryinventory.ui.theme.AppStrings.predicted
import com.example.groceryinventory.ui.theme.AppStrings.qtyAvailable
import com.example.groceryinventory.ui.theme.AppStrings.totalQty
import com.example.groceryinventory.ui.theme.FontSizes
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.PaddingValues
import com.example.groceryinventory.ui.theme.RadiusValues
import com.example.groceryinventory.ui.theme.SizeValues

@Composable
fun GroceryCard(item: Product) {
    Card(
        elevation = CardDefaults.cardElevation(PaddingValues.xs),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(RadiusValues.xLarge),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(PaddingValues.xlarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(PaddingValues.medium))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id =item.imageRes),
                    contentDescription = item.name,
                    modifier = Modifier
                        .size(SizeValues.imageLarge)
                        .weight(1f)
                )
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.weight(1f)
                ) {
                    StockStatusBadge(item.stockStatus)

                }
            }

            Row(
            ) {
                Column(modifier = Modifier.weight(1f)) {

                    Text(
                    text = item.name,
                    fontSize = FontSizes.xLarge,
                    fontWeight = FontWeight.Bold,
                    color = Green
                )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.packages),
                            contentDescription = qtyAvailable,
                            modifier = Modifier.size(SizeValues.iconMedium)
                        )

                        Spacer(modifier = Modifier.width(PaddingValues.xs))

                        Text(
                            "$qtyAvailable: ${item.remainingQuantity}",
                            fontSize = FontSizes.medium
                        )
                    }

                    Spacer(modifier = Modifier.height(PaddingValues.xs))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.shipping),
                            contentDescription = totalQty,
                            modifier = Modifier.size(SizeValues.iconMedium)
                        )

                        Spacer(modifier = Modifier.width(PaddingValues.xs))

                        Text(
                            "$totalQty ${item.totalQuantity}",
                            fontSize = FontSizes.medium
                        )
                    }
                    Spacer(modifier = Modifier.height(PaddingValues.xs))


                }
                VerticalDivider(
                    thickness = DividerDefaults.Thickness,
                    color = DividerDefaults.color,
                    modifier = Modifier.height(SizeValues.dividerHeight)
                )

                Spacer(modifier = Modifier.width(PaddingValues.xlarge))

                ConsumptionLineChart(item.last7DaysSales)

            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.predictive_analysis),
                    contentDescription = predicted, modifier = Modifier.size(SizeValues.iconMedium)
                )

                Spacer(modifier = Modifier.width(PaddingValues.xs))


            Text(
                text = "$predicted ${item.predictedNextDay}",
                fontSize = FontSizes.medium
            )
        }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GroceryCardPreview() {
    val sampleProduct = Product(
        id = 1,
        name = "Rice",
        totalQuantity = 25,
        last7DaysSales = listOf(2, 3, 1, 2, 2, 3, 2),
        predictedNextDay = 2,
        remainingQuantity = 15,
        stockStatus = StockStatus.STABLE,
        remainingPercentage = 60.0,
        imageRes = R.drawable.rice
    )

    GroceryCard(item = sampleProduct)
}