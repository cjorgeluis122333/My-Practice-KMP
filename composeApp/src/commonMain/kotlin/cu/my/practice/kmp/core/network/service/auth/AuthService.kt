package cu.my.practice.kmp.core.network.service.auth

import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse

interface AuthService {

    suspend fun login(userLoginRequest: UserLoginRequest): UserLoginResponse

    suspend fun register(userToRegister: UserResponse): UserResponse

}