package cu.my.practice.kmp.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val LocalTicketColor: ProvidableCompositionLocal<TicketColors> =
    staticCompositionLocalOf { TicketColors() }

/**
 * All colors of the app
 * CrmColors
 */
@Immutable
data class TicketColors(
    val black: Color = Color.Black,
    val white: Color = Color.White,
    val gris: Color = Gris,
    val gold: Color = Gold,
    val blueTheme: Color = BlueTheme,
    val transparentBlueTheme: Color = TransparentBlueTheme,
    val transparent: Color = Color.Transparent,
    val notificationDefault: Color = ColorNotificationDefault,
    val notificationInfo: Color = ColorNotificationInfo,
    val notificationConfirmation: Color = ColorNotificationConfirmation,
    val notificationPublicity: Color = ColorNotificationPublicity,
    val notificationAlert: Color = ColorNotificationAlert,
    val notificationLink: Color = ColorNotificationLink,
    val notificationAdvice: Color = ColorNotificationAdvice,
    val notificationNew: Color = ColorNotificationNew,
    val notificationWarning: Color = ColorNotificationWarning,
    val notificationSelected: Color = ColorNotificationSelected,
)

