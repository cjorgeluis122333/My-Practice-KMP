package cu.my.practice.kmp.core.network.datasource

import cu.my.practice.kmp.core.domain.datasource.remote.AuthRemoteDataSource
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.core.network.service.auth.AuthService
import cu.my.practice.kmp.core.network.service.auth.AuthServiceImp

class AuthRemoteDataSourceImpl(
    private val authServiceImp: AuthService,
) : AuthRemoteDataSource, RemoteDatasourceAbstraction() {
    override suspend fun postLogin(userLoginRequest: UserLoginRequest): ResultValue<UserLoginResponse> =
        safeApiCall {
            authServiceImp.login(userLoginRequest)
        }

    override suspend fun postRegister(userLoginRequest: UserResponse): ResultValue<UserResponse> =
        safeApiCall {
            authServiceImp.register(userLoginRequest)
        }
}