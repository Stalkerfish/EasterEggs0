import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
@Preview
fun midButton() {
    // Load the vector drawable from resources
    val backgroundPainter: Painter = painterResource(resourcePath = "drawable/rectangle.svg")

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.padding(22.dp)
    ) {
        // Add the background image
        Image(
            painter = backgroundPainter,
            contentDescription = "Button Background",
            contentScale = ContentScale.FillBounds, // Fill the entire box
            modifier = Modifier
                .padding(8.dp) // Adjust this based on your layout needs
        )

        // Add the Button on top of the background image
        Text(
            text = no_ideas_for_this_button_yet,
            fontFamily = MyCustomFontFamily,
            fontSize = 16.sp,
            color = Platinum
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImageWithDialog(path: String) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<String?>(null) }

    val imagePainter: Painter = painterResource(path) // Replace with your image resource path
    val itemList = listOf("Orb 1", "Orb 2", "Orb 3") // Replace with your actual items

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
            Surface(modifier = Modifier.padding(16.dp)) {
                Column {
                    Text(text = "Select an Orb", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
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

@Composable
@Preview
fun home () {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(color = RoseRed)
                .fillMaxWidth()
                .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painterResource(resourcePath = "drawable/frame.png"), null)

            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier = Modifier.align(Alignment.Start).padding(10.dp)) {
                Text(
                    text = home_room,
                    fontSize = 36.sp,
                    fontFamily = MyCustomFontFamily,
                    color = Timberwolf
                )

                Image(
                    painterResource(resourcePath = "drawable/just_a_line.svg"), null,
                    modifier = Modifier.align(Alignment.CenterVertically).padding(14.dp)
                )
            }

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Column() {
                    ImageWithDialog(
                        path = "drawable/wardrobe.svg"
                    )

                    Text(
                        text = wardrobe,
                        fontSize = 18.sp,
                        fontFamily = MyCustomFontFamily,
                        color = Timberwolf,
                        modifier = Modifier.padding(48.dp, 8.dp, 0.dp, 0.dp)
                    )
                }

                Column() {
                    Image(
                        painterResource(resourcePath = "drawable/bag.svg"), null,
                        modifier = Modifier.padding(0.dp, 36.dp, 25.dp, 0.dp)
                    )

                    Text(
                        text = bag,
                        fontSize = 18.sp,
                        fontFamily = MyCustomFontFamily,
                        color = Timberwolf,
                        modifier = Modifier.padding(42.dp, 0.dp, 0.dp, 0.dp)
                    )
                }
            }
            midButton()

            Row(modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp) .align(Alignment.Start)) {
                Image(painterResource(resourcePath = "drawable/book.svg"), null)
                Image(painterResource(resourcePath = "drawable/phone.svg"), null,
                    modifier = Modifier.padding(38.dp, 0.dp, 10.dp, 0.dp))
                Image(painterResource(resourcePath = "drawable/settings.svg"), null,
                    modifier = Modifier.padding(38.dp, 0.dp, 10.dp, 0.dp))
            }
        }
    }
}