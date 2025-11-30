import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.groceryinventory.ui.theme.FontSizes.medium
import com.example.groceryinventory.ui.theme.Green
import com.example.groceryinventory.ui.theme.PaddingValues
import com.example.groceryinventory.ui.theme.RadiusValues
import com.example.groceryinventory.ui.theme.SizeValues

//@Composable
//fun GreenOutlinedButton(
//    onClick: () -> Unit,
//    text: String,
//    image: Int
//) {
//
//    Box(
//        modifier = Modifier
//            .width(80.dp)
//            .border(
//                BorderStroke(1.dp, Green),
//                shape = RoundedCornerShape(RadiusValues.medium)
//            )
//            .clickable(onClick = onClick)
//            .padding(vertical = PaddingValues.xs),
//        contentAlignment = Alignment.Center
//    ) {
//        Row {
//            Image(
//                painter = painterResource(id = image),
//                contentDescription = "Arrow",
//                modifier = Modifier.size(SizeValues.iconSmall)
//            )
//            Text(
//                text = text,
//                color = Green,
//                fontSize = medium,
//            )
//        }
//
//    }
//}