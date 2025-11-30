import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.groceryinventory.domain.model.Product
import com.example.groceryinventory.ui.compose.GroceryCard
import com.example.groceryinventory.ui.compose.SearchAndSortBar
import com.example.groceryinventory.ui.theme.Green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryScreen(
    products: List<Product>,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    onSortAscending: () -> Unit,
    onSortDescending: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Grocery Inventory", color = Green) }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                SearchAndSortBar(
                    searchQuery = searchQuery,
                    onSearchChange = onSearchChange,
                    onSortAscending = onSortAscending,
                    onSortDescending = onSortDescending
                )

                Spacer(modifier = Modifier.height(12.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(products) { item ->
                        GroceryCard(item)
                    }
                }
            }
        }
    )
}
//
//@Preview(showBackground = true)
//@Composable
//fun GroceryScreenPreview() {
//    val sampleProducts = listOf(
//        Product(
//            id = 1,
//            name = "Rice",
//            totalQuantity = 25,
//            last7DaysSales = listOf(2, 3, 1, 2, 2, 3, 2),
//            predictedNextDay = 2,
//            remainingQuantity = 15,
//            stockStatus = StockStatus.STABLE,
//            remainingPercentage = 60.0
//        ),
//        Product(
//            id = 2,
//            name = "Sugar",
//            totalQuantity = 20,
//            last7DaysSales = listOf(1, 1, 2, 1, 1, 1, 1),
//            predictedNextDay = 1,
//            remainingQuantity = 14,
//            stockStatus = StockStatus.WARNING,
//            remainingPercentage = 70.0
//        ),
//        Product(
//            id = 3,
//            name = "Milk",
//            totalQuantity = 30,
//            last7DaysSales = listOf(4, 5, 4, 4, 5, 4, 4),
//            predictedNextDay = 4,
//            remainingQuantity = 5,
//            stockStatus = StockStatus.CRITICAL,
//            remainingPercentage = 16.6
//        )
//    )
//
//    GroceryScreen(
//        products = sampleProducts,
//        searchQuery = "",
//        onSearchChange = {},
//        onSortAscending = {},
//        onSortDescending = {}
//    )
//}