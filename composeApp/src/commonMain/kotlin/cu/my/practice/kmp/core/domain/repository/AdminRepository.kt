package cu.my.practice.kmp.core.domain.repository

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse

interface AdminRepository {

    suspend fun findUsers():ResultValue<List<UserResponse>>
    suspend fun updateUser():ResultValue<UserResponse>
    suspend fun insertUser():ResultValue<UserResponse>
    suspend fun deleteUser():ResultValue<Boolean>

}