import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WardrobeShelf(path: String, itemList: MutableList<Item>) {
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
            Surface(
                modifier = Modifier.size(500.dp),
                shape = RoundedCornerShape(30.dp),
                color = MarianBlue
            ) {
                if (itemList.isNotEmpty()) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Select an Orb",
                            fontSize = 20.sp,
                            fontFamily = GoogleSansBold,
                            color = Timberwolf,
                            modifier = Modifier.padding(8.dp)
                        )
                        itemList.forEach { item ->
                            ListItem(
                                text = { item.name?.let { Text(text = it) } },
                                modifier = Modifier.clickable {
                                    selectedItem = item.toString()
                                    item.useItem()
                                    itemList.remove(item)
                                    showDialog = false // Close the dialog

                                }
                            )
                        }
                    }
                } else {
                    Column(modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(
                            text = there_is_no_orbs_here,
                            fontSize = 20.sp,
                            fontFamily = GoogleSansBold,
                            color = Timberwolf,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}
