package cu.my.practice.kmp.core.domain.repository

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse

interface UserRepository {

    suspend fun findUsers(): ResultValue<List<UserResponse>>
    suspend fun findUserByUsername(): ResultValue<UserResponse>

}