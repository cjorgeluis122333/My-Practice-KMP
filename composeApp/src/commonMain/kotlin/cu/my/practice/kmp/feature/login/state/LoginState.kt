package cu.my.practice.kmp.feature.login.state

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading:Boolean = false,
    val passwordError: String = "",
    val usernameError: String = "",
    val errorMessage:String? = null
    )