package cu.my.practice.kmp.core.ui.theme.builder

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import cu.my.practice.kmp.core.ui.theme.builder.backgroundDark
import cu.my.practice.kmp.core.ui.theme.builder.backgroundLight
import cu.my.practice.kmp.core.ui.theme.builder.errorContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.errorContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.errorDark
import cu.my.practice.kmp.core.ui.theme.builder.errorLight
import cu.my.practice.kmp.core.ui.theme.builder.inverseOnSurfaceDark
import cu.my.practice.kmp.core.ui.theme.builder.inverseOnSurfaceLight
import cu.my.practice.kmp.core.ui.theme.builder.inversePrimaryDark
import cu.my.practice.kmp.core.ui.theme.builder.inversePrimaryLight
import cu.my.practice.kmp.core.ui.theme.builder.inverseSurfaceDark
import cu.my.practice.kmp.core.ui.theme.builder.inverseSurfaceLight
import cu.my.practice.kmp.core.ui.theme.builder.onBackgroundDark
import cu.my.practice.kmp.core.ui.theme.builder.onBackgroundLight
import cu.my.practice.kmp.core.ui.theme.builder.onErrorContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.onErrorContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.onErrorDark
import cu.my.practice.kmp.core.ui.theme.builder.onErrorLight
import cu.my.practice.kmp.core.ui.theme.builder.onPrimaryContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.onPrimaryContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.onPrimaryDark
import cu.my.practice.kmp.core.ui.theme.builder.onPrimaryLight
import cu.my.practice.kmp.core.ui.theme.builder.onSecondaryContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.onSecondaryContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.onSecondaryDark
import cu.my.practice.kmp.core.ui.theme.builder.onSecondaryLight
import cu.my.practice.kmp.core.ui.theme.builder.onSurfaceDark
import cu.my.practice.kmp.core.ui.theme.builder.onSurfaceLight
import cu.my.practice.kmp.core.ui.theme.builder.onSurfaceVariantDark
import cu.my.practice.kmp.core.ui.theme.builder.onSurfaceVariantLight
import cu.my.practice.kmp.core.ui.theme.builder.onTertiaryContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.onTertiaryContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.onTertiaryDark
import cu.my.practice.kmp.core.ui.theme.builder.onTertiaryLight
import cu.my.practice.kmp.core.ui.theme.builder.outlineDark
import cu.my.practice.kmp.core.ui.theme.builder.outlineLight
import cu.my.practice.kmp.core.ui.theme.builder.outlineVariantDark
import cu.my.practice.kmp.core.ui.theme.builder.outlineVariantLight
import cu.my.practice.kmp.core.ui.theme.builder.primaryContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.primaryContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.primaryDark
import cu.my.practice.kmp.core.ui.theme.builder.primaryLight
import cu.my.practice.kmp.core.ui.theme.builder.scrimDark
import cu.my.practice.kmp.core.ui.theme.builder.scrimLight
import cu.my.practice.kmp.core.ui.theme.builder.secondaryContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.secondaryContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.secondaryDark
import cu.my.practice.kmp.core.ui.theme.builder.secondaryLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceBrightDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceBrightLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerHighDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerHighLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerHighestDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerHighestLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerLowDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerLowLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerLowestDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceContainerLowestLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceDimDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceDimLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceLight
import cu.my.practice.kmp.core.ui.theme.builder.surfaceVariantDark
import cu.my.practice.kmp.core.ui.theme.builder.surfaceVariantLight
import cu.my.practice.kmp.core.ui.theme.builder.tertiaryContainerDark
import cu.my.practice.kmp.core.ui.theme.builder.tertiaryContainerLight
import cu.my.practice.kmp.core.ui.theme.builder.tertiaryDark
import cu.my.practice.kmp.core.ui.theme.builder.tertiaryLight

val LightColors = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

val DarkColors = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)
