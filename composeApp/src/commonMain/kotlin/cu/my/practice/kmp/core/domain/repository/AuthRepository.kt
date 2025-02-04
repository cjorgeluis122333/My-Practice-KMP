package cu.my.practice.kmp.core.domain.repository

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse

interface AuthRepository {
    suspend fun postLogin(userToLogin: UserLoginRequest): ResultValue<UserLoginResponse>
    suspend fun postRegister(userToRegister: UserResponse): ResultValue<UserResponse>


    suspend fun getUserName(): String?
    suspend fun getToken(): String?

    suspend fun saveUserName(name:String)
    suspend fun saveToken(token:String)
}