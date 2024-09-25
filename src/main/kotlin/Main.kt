import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {

    var currentScreen by remember { mutableStateOf(Room.HOME) }
    Window(
        onCloseRequest = ::exitApplication,
        title = "EasterEggs_0",
        state = WindowState(width = 415.dp, height = 920.dp),
        undecorated = false,
    ) {
        NavigationHost(currentScreen = currentScreen, onNavigate = { screen ->
            currentScreen = screen
        })
    }
}

@Composable
fun NavigationHost(currentScreen: Room, onNavigate: (Room) -> Unit) {
    when (currentScreen) {
        Room.HOME -> home(onNavigate = onNavigate)
        Room.App -> app(onNavigate = onNavigate)
        Room.EARTH -> Earth(onNavigate = onNavigate)
        Room.Settings -> TODO()
    }
}

enum class Room {
    App, HOME, EARTH, Settings
}