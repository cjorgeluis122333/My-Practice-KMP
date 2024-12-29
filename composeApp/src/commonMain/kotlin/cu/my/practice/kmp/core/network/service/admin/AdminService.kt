package cu.my.practice.kmp.core.network.service.admin

import cu.my.practice.kmp.core.network.response.UserResponse

interface AdminService {

    suspend fun updateUser(userToUpdate: UserResponse): UserResponse
    suspend fun insertUser(userToUpdate: UserResponse): UserResponse
    suspend fun deleteUser(id: Int): Boolean
}