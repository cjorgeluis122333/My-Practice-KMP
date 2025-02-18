package cu.my.practice.kmp.core.ui.xetid_ticket

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

val LocalDimen: ProvidableCompositionLocal<Dimen> = compositionLocalOf { Dimen() }

val LocalApplicationId: ProvidableCompositionLocal<String> = compositionLocalOf { "" }