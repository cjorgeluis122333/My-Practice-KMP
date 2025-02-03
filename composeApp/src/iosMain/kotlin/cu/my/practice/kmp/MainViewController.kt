package cu.my.practice.kmp

import androidx.compose.ui.window.ComposeUIViewController

import cu.my.practice.kmp.shared.App
import cu.my.practice.kmp.shared.di.initKoinNotContext

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoinNotContext()
    }
) { App() }