import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WardrobeShelf(path: String, itemList: List<String>) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<String?>(null) }

    val imagePainter: Painter = painterResource(path) // Replace with your image resource path

    // Show image and handle click
    Image(
        painter = imagePainter,
        contentDescription = null,
        modifier = Modifier
            .clickable { showDialog = true }
            .padding(25.dp, 25.dp, 75.dp, 0.dp)
    )

    // Show dialog
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(modifier = Modifier.wrapContentHeight(),
                shape = RoundedCornerShape(30.dp),
                color = MarianBlue
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = "Select an Orb", fontSize = 20.sp, fontFamily = MyCustomFontFamily, color = Timberwolf, modifier = Modifier.padding(8.dp))
                    itemList.forEach { item ->
                        ListItem(
                            text = { Text(text = item) },
                            modifier = Modifier.clickable {
                                selectedItem = item
                                showDialog = false // Close the dialog
                                // Handle item selection
                            }
                        )
                    }
                }
            }
        }
    }

    // Display selected item or do something with it
    if (selectedItem != null) {
        Text(text = "Selected Item: $selectedItem", modifier = Modifier.padding(16.dp))
    }
}
