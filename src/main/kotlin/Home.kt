import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



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

            Row(modifier = Modifier.align(Alignment.Start) .padding(10.dp)) {
                Text(
                    text = home_room,
                    fontSize = 36.sp,
                    fontFamily = MyCustomFontFamily,
                    color = Timberwolf)

                Image(painterResource(resourcePath = "drawable/just_a_line.svg"), null,
                    modifier = Modifier.align(Alignment.CenterVertically) .padding(14.dp))
            }

            Row(modifier = Modifier.align(Alignment.Start)) {
                Column() {
                    Image(
                        painterResource(resourcePath = "drawable/wardrobe.svg"), null,
                        modifier = Modifier.padding(25.dp, 25.dp, 75.dp, 0.dp)
                    )

                    Text(
                        text = wardrobe,
                        fontSize = 18.sp,
                        fontFamily = MyCustomFontFamily,
                        color = Timberwolf,
                        modifier = Modifier.padding(48.dp, 8.dp, 0.dp, 0.dp)
                    )
                }

                Column(){
                    Image(painterResource(resourcePath = "drawable/bag.svg"), null,
                        modifier = Modifier.padding(0.dp, 36.dp, 25.dp, 0.dp))
                    
                    Text(
                        text = bag,
                        fontSize = 18.sp,
                        fontFamily = MyCustomFontFamily,
                        color = Timberwolf,
                        modifier = Modifier.padding(42.dp, 0.dp, 0.dp, 0.dp))
                    }
                }
            }
        }
    }