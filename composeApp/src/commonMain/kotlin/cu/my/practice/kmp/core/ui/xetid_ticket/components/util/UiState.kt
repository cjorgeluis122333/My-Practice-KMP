package cu.my.practice.kmp.core.ui.xetid_ticket.components.util

import org.jetbrains.compose.resources.StringResource


sealed interface UiState<out T : Any?> {
    /**
     * @param data was success*/
    data class Success<T>(val data: T? = null, val message: StringResource? = null) : UiState<T>
    data class Error(val message: StringResource) : UiState<Nothing>
    data class Loading(val message: StringResource? = null) : UiState<Nothing>
}