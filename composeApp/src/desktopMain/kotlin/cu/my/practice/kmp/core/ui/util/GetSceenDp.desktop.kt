package cu.my.practice.kmp.core.ui.util

import androidx.compose.runtime.Composable
import java.awt.Toolkit

@Composable
actual fun getScreenHeightDp(): Int {
    val toolkit = Toolkit.getDefaultToolkit()
    val screenSize = toolkit.screenSize // Tamaño en píxeles (java.awt.Dimension)
    val dpi =
        toolkit.screenResolution   // DPI de la pantalla, por ejemplo 96 en muchos casos de escritorio
    // Conversión de píxeles a "dp"
    return (screenSize.height * 160f / dpi).toInt()
}