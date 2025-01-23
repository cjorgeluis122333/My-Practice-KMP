package cu.my.practice.kmp.feature.login.state

import cu.my.practice.kmp.core.model.user.UserModel

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading:Boolean = false,
    val passwordError: String = "",
    val usernameError: String = "",
    val errorMessage:String? = null,
    val users:List<UserModel> = emptyList()
    )