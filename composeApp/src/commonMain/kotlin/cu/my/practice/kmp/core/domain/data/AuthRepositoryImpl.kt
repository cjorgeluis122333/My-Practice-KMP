package cu.my.practice.kmp.core.domain.data

import cu.my.practice.kmp.core.domain.repository.AuthRepository
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse

class AuthRepositoryImpl():AuthRepository {
    override suspend fun postLogin(userToLogin: UserLoginRequest): ResultValue<UserLoginResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun postRegister(userToRegister: UserLoginRequest): ResultValue<UserResponse> {
        TODO("Not yet implemented")
    }
}