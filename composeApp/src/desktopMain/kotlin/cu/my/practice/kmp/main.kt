package cu.my.practice.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cu.my.practice.kmp.shared.App
import cu.my.practice.kmp.shared.di.initKoinNotContext

fun main() {
    initKoinNotContext()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "My-Practice-KMP",
        ) {
            App()
        }
    }
}