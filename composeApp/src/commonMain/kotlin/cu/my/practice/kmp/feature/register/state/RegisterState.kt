package cu.my.practice.kmp.feature.register.state

data class RegisterState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val errorEmail: String? = null,
    val errorName: String? = null,
    val errorPassword: String? = null,
    val errorMessage: String? = null,
    val isLoading:Boolean = false
)