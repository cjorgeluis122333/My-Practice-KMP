package cu.my.practice.kmp.core.domain.datasource.remote

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest

interface AuthRemoteDataSource {
   suspend fun postLogin(userLoginRequest: UserLoginRequest):ResultValue<UserLoginResponse>
   suspend fun postRegister(userLoginRequest: UserResponse):ResultValue<UserResponse>
}