package cu.my.practice.kmp.core.model.auth

data class UserLogin(
    val username: String,
    val message: String,
    val token: String
)