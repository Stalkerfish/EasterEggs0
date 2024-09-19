import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "EasterEggs_0",
        state = WindowState(width = 384.dp, height = 854.dp),
        undecorated = false,
    ) {
        home()
    }
}