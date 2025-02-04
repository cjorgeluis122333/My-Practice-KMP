package cu.my.practice.kmp.core.ui

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Login : Route

    @Serializable
    data object Register : Route

    @Serializable
    data object Home : Route

    @Serializable
    data object Graph : Route

    @Serializable
    data object Admin : Route

    @Serializable
    data object Contact : Route

    @Serializable
    data object Rick : Route

    @Serializable
    data object Splash: Route
}