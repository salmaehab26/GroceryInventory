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

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
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
