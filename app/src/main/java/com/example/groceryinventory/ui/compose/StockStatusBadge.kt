package com.example.groceryinventory.ui.compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.groceryinventory.domain.model.StockStatus
import com.example.groceryinventory.ui.theme.FontSizes.largeFont
import com.example.groceryinventory.ui.theme.PaddingValues.large
import com.example.groceryinventory.ui.theme.PaddingValues.padding5
import com.example.groceryinventory.ui.theme.SizeValues.small
import com.example.groceryinventory.ui.theme.SizeValues.verySmall

@Composable
fun StockStatusBadge(status: StockStatus) {

    Row(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .border(1.dp,status.color, RoundedCornerShape(12.dp))
            .background(White, RoundedCornerShape(12.dp))
            .padding(horizontal = large, vertical = padding5)
            .width(100.dp)
    ) {
        Image(
            painter = painterResource(id =status.image),
            contentDescription = "Warning",
            modifier = Modifier.size(small)
        )
        Spacer(modifier = Modifier.width(verySmall))
        Text(
            text = status.displayText,
            color = status.color,
            fontWeight = FontWeight.Bold,
            fontSize =largeFont
        )
    }
}

