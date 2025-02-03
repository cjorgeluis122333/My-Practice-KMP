package cu.my.practice.kmp.core.domain.datasource.remote

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse

interface UserRemoteDatasource {

    suspend fun getAllUser(): ResultValue<List<UserResponse>>

    suspend fun getUserById(id: Int): ResultValue<UserResponse>


}