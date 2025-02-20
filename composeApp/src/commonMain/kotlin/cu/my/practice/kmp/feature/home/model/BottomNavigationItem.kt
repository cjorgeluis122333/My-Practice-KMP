package cu.my.practice.kmp.feature.home.model

import org.jetbrains.compose.resources.DrawableResource

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: DrawableResource,
    val unselectedIcon: DrawableResource,
    val hasNews: Boolean = false,
    val badgeCount: Int? = null
)