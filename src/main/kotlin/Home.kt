import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun home (onNavigate: (Room) -> Unit) {

    MaterialTheme {
        Column(
            modifier = Modifier
                .background(color = RoseRed)
                .fillMaxWidth()
                .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val items = mutableListOf<Item>()

            Image(painterResource(resourcePath = "drawable/frame.png"), null)

            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier = Modifier.align(Alignment.Start).padding(10.dp)) {
                Text(
                    text = home_room,
                    fontSize = 36.sp,
                    fontFamily = GoogleSansBold,
                    color = Timberwolf
                )

                Image(
                    painterResource(resourcePath = "drawable/just_a_line.svg"), null,
                    modifier = Modifier.align(Alignment.CenterVertically).padding(14.dp)
                )
            }

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Column() {
                    WardrobeShelf(
                        path = "drawable/wardrobe.svg",
                        itemList = items
                    )

                    Text(
                        text = wardrobe,
                        fontSize = 18.sp,
                        fontFamily = GoogleSansBold,
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
                        fontFamily = GoogleSansBold,
                        color = Timberwolf,
                        modifier = Modifier.padding(42.dp, 0.dp, 0.dp, 0.dp)
                    )
                }
            }

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
                            .clickable {
                                val orb = Orb(Room.App, Room.App.name, onNavigate)
                                items.add(orb)
                            }
                    )

                    // Add the Button on top of the background image
                    Text(
                        text = no_ideas_for_this_button_yet,
                        fontFamily = GoogleSansBold,
                        fontSize = 16.sp,
                        color = Platinum
                    )
                }
            }

            midButton()

            Row(modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp).align(Alignment.Start)) {
                Image(painterResource(resourcePath = "drawable/book.svg"), null)
                Image(
                    painterResource(resourcePath = "drawable/phone.svg"), null,
                    modifier = Modifier.padding(38.dp, 0.dp, 10.dp, 0.dp)
                )
                Image(
                    painterResource(resourcePath = "drawable/settings.svg"), null,
                    modifier = Modifier.padding(38.dp, 0.dp, 10.dp, 0.dp)
                )
            }
        }
    }
}