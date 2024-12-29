package cu.my.practice.kmp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cu.my.practice.kmp.core.domain.UserRemoteDatasource
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.ui.Route
import cu.my.practice.kmp.shared.AppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val remoteDatasource: UserRemoteDatasource
):ViewModel() {

    private val _state: MutableStateFlow<AppState> = MutableStateFlow(AppState())
    val state = _state.asStateFlow()
    var firstScreen = Route.Login


    fun getUserByIf(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            stateHandler(isLoading = true)
            delay(1000L)
            when (val getUser = remoteDatasource.getUserById(id)) {
                is ResultValue.Error -> {
                    stateHandler(
                        error = getUser.exception.message ?: "Happen unexpected error",
                        isLoading = false
                    )
                }

                is ResultValue.Success ->
                    stateHandler(
                        data = emptyList(),
                        user = getUser.data,
                        isLoading = false,
                        error = null
                    )
            }
        }
    }

    fun getAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            stateHandler(isLoading = true)
            delay(1000L)

            when (val users = remoteDatasource.getAllUser()) {
                is ResultValue.Error ->
                    stateHandler(
                        error = users.exception.message ?: "Happen unexpected error",
                        isLoading = false
                    )


                is ResultValue.Success ->
                    stateHandler(
                        error = null,
                        data = users.data,
                        isLoading = false
                    )
            }
        }
    }

    private fun stateHandler(
        data: List<UserResponse> = _state.value.data,
        user: UserResponse? = _state.value.user,
        error: String? = _state.value.error,
        isLoading: Boolean = _state.value.isLoading
    ) {
        _state.update {
            it.copy(
                data = data,
                user = user,
                isLoading = isLoading,
                error = error
            )
        }
    }

}