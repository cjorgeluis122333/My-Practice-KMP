package cu.my.practice.kmp.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cu.my.practice.kmp.core.domain.datasource.remote.AuthRemoteDataSource
import cu.my.practice.kmp.core.domain.repository.AuthRepository
import cu.my.practice.kmp.core.domain.repository.HomeRepository
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.model.user.UserModel
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.feature.login.state.LoginState
import cu.my.practice.kmp.feature.login.state.SussesLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authRepository: AuthRepository,
    private val homeRepository: HomeRepository
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())

    val state = _state.onStart {
        defaultCacheValues()
        defaultDataBaseValues()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = _state.value
    )

    private val _onSussesLogin = MutableSharedFlow<SussesLogin>()
    val onSussesLogin: SharedFlow<SussesLogin> = _onSussesLogin.asSharedFlow()

    fun insertUserToDatabase() {
        viewModelScope.launch {
            homeRepository.insertUserEntity(
                UserModel(
                    name = _state.value.username,
                    password = _state.value.password
                )
            )


        }

    }


    fun onLoginDelete() {
        viewModelScope.launch {
            authRepository.saveUserName(_state.value.username)
            authRepository.saveToken(_state.value.password)
        }
        println(_state.value.users)
    }


    fun onLogin() {
        stateHandler(
            isLoading = true,
            errorMessage = null
        )
        viewModelScope.launch(Dispatchers.IO) {
            _state.value.let {
                when (val result =
                    authRemoteDataSource.postLogin(
                        userLoginRequest = UserLoginRequest(
                            it.username,
                            it.password
                        )
                    )
                ) {
                    is ResultValue.Error -> stateHandler(errorMessage = result.exception.message)
                    is ResultValue.Success<*> -> {
                        println("==========================================The login was susses")
                        _onSussesLogin.emit(SussesLogin.Susses)
                    }
                }
            }
        }
        stateHandler(
            isLoading = false
        )

    }


    private fun defaultCacheValues() {
        viewModelScope.launch {
            stateHandler(
                userName = authRepository.getUserName() ?: "",
                password = authRepository.getToken() ?: ""
            )
        }
    }

    private fun defaultDataBaseValues(){
        homeRepository.selectAllUser().onEach {user ->
            _state.update {
                it.copy(
                    users = user
                )
            }
        }.launchIn(viewModelScope)
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