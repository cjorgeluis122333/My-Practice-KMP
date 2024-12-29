package cu.my.practice.kmp.core.domain

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest

interface AuthRemoteDataSource {
   suspend fun postLogin(userLoginRequest: UserLoginRequest):ResultValue<UserLoginResponse>
}