package cu.my.practice.kmp.core.domain.repository

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse

interface AuthRepository {
    suspend fun postLogin(userToLogin: UserLoginRequest): ResultValue<UserLoginResponse>
    suspend fun postRegister(userToRegister: UserLoginRequest): ResultValue<UserResponse>
}