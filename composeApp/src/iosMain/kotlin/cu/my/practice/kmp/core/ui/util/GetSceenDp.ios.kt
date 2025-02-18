package cu.my.practice.kmp.core.ui.util


import androidx.compose.runtime.Composable
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen

@Composable
actual fun getScreenHeightDp(): Int {
    // UIScreen.mainScreen.bounds es un CGRect.
    // Usamos useContents para extraer la altura (en puntos).
    var height = 0.0
    UIScreen.mainScreen.bounds.useContents {
        height = size.height
    }
    // Se asume que 1 punto ≈ 1 dp para propósitos de layout.
    return height.toInt()
}