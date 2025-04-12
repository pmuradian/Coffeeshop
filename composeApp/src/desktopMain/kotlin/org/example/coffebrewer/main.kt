package org.example.coffebrewer

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CoffeBrewer",
    ) {
        App()
    }
}