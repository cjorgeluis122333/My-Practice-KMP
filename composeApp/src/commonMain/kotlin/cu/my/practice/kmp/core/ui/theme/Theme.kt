package cu.my.practice.kmp.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import cu.my.practice.kmp.core.ui.theme.builder.DarkColors
import cu.my.practice.kmp.core.ui.theme.builder.LightColors
import cu.my.practice.kmp.core.ui.xetid_ticket.Dimen
import cu.my.practice.kmp.core.ui.xetid_ticket.LocalDimen

@Suppress("DEPRECATION")
@Composable
fun TicketTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val ticketColors = TicketColors()
    val colors = if (darkTheme)
        DarkColors
    else
        LightColors


    CompositionLocalProvider(
        values = arrayOf(
            LocalDimen provides Dimen(),
            LocalTicketColor provides ticketColors,
        ),
    ) {
        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}