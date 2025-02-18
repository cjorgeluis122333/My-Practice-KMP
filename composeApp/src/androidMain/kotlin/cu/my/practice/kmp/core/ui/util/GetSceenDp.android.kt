package cu.my.practice.kmp.core.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
actual fun getScreenHeightDp(): Int {
    // Obtiene la altura de la pantalla en dp usando LocalConfiguration (API específica de Android)
    return LocalConfiguration.current.screenHeightDp
}