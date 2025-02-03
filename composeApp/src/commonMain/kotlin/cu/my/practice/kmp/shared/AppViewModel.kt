package cu.my.practice.kmp.shared

import androidx.lifecycle.ViewModel
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.ui.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel(
) : ViewModel() {

    private val _appState: MutableStateFlow<AppState> = MutableStateFlow(AppState())
    val appState = _appState.asStateFlow()
    var firstScreen = Route.Login


    private fun stateHandler(
        data: List<UserResponse> = _appState.value.data,
        user: UserResponse? = _appState.value.user,
        error: String? = _appState.value.error,
        isLoading: Boolean = _appState.value.isLoading
    ) {
        _appState.update {
            it.copy(
                data = data,
                user = user,
                isLoading = isLoading,
                error = error
            )
        }
    }

}