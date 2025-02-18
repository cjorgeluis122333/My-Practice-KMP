package cu.my.practice.kmp.core.ui.xetid_ticket.components.util

import cu.my.practice.kmp.core.model.wallet.PayCreate
import org.jetbrains.compose.resources.StringResource


sealed interface SimplerUiState<out T : Any> {
    data object Loading : SimplerUiState<Nothing>
    data object Idle : SimplerUiState<Nothing>
    data class Error(val message: StringResource) : SimplerUiState<Nothing>

    data class Success<out T : Any>(val data: T? = null) : SimplerUiState<T>

    data class PaymentRequired(val payCreate: PayCreate) : SimplerUiState<Nothing>

}

data class Show(
    var showRequirePayDialog: Boolean = false,
    val payAccepted: Boolean = false,
    val payCreate: PayCreate? = null,
)