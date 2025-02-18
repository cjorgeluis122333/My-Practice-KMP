package cu.my.practice.kmp.core.ui.theme

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import cu.my.practice.kmp.core.ui.theme.builder.DarkColors


val ColorScheme.isDarkMode
    @Composable
    @ReadOnlyComposable
    get() = background == DarkColors.background

val ColorScheme.textFieldContainer: Color
    @Composable
    @ReadOnlyComposable
    get() = if (isDarkMode) TextFieldBackgroundDark else TextFieldBackgroundLight

val ColorScheme.backgroundSurface: Color
    @Composable
    @ReadOnlyComposable
    get() = if (isDarkMode) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background

val ColorScheme.primaryBackground: Color
    @Composable
    @ReadOnlyComposable
    get() = if (!isDarkMode) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background

val ColorScheme.onPrimaryBackground: Color
    @Composable
    @ReadOnlyComposable
    get() = if (!isDarkMode) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground

@OptIn(ExperimentalMaterial3Api::class)
val ColorScheme.bottomSheetContainerColor: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.surfaceColorAtElevation(
        BottomSheetDefaults.Elevation
    )
