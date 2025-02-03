package cu.my.practice.kmp.shared

import cu.my.practice.kmp.core.network.response.UserResponse

data class AppState(
    val data:List<UserResponse> = emptyList(),
    val user:UserResponse? = null,
    val error: String? = null,
    val isLoading: Boolean = false
)