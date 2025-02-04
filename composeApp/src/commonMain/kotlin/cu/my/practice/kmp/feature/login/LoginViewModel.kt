package cu.my.practice.kmp.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cu.my.practice.kmp.core.domain.usecase.auth.AuthUseCase
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.feature.login.state.LoginState
import cu.my.practice.kmp.feature.login.state.SussesLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: AuthUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _onSussesLogin = MutableSharedFlow<SussesLogin>()
    val onSussesLogin: SharedFlow<SussesLogin> = _onSussesLogin.asSharedFlow()


    fun onLogin() {
        stateHandler(
            isLoading = true,
            errorMessage = null
        )
        viewModelScope.launch(Dispatchers.IO) {
            _state.value.let {
                stateHandler(isLoading = true)
                when (val result =
                    loginUseCase.loginUseCase(
                        UserLoginRequest(
                            it.username,
                            it.password
                        )
                    )
                ) {
                    is ResultValue.Error -> {
                        stateHandler(errorMessage = result.exception.message)
                        stateHandler(isLoading = false)
                        _onSussesLogin.emit(SussesLogin.Failed)

                    }

                    is ResultValue.Success<*> -> {
                        println("==========================================The login was susses")
                        stateHandler(isLoading = false)
                        _onSussesLogin.emit(SussesLogin.Susses)

                    }
                }
            }
        }
    }


    fun stateHandler(
        userName: String = _state.value.username,
        password: String = _state.value.password,
        isLoading: Boolean = _state.value.isLoading,
        errorPassword: String = _state.value.passwordError,
        errorUsername: String = _state.value.usernameError,
        errorMessage: String? = _state.value.errorMessage
    ) {
        _state.update {
            it.copy(
                username = userName,
                password = password,
                isLoading = isLoading,
                errorMessage = errorMessage,
                passwordError = errorPassword,
                usernameError = errorUsername
            )
        }
    }


}