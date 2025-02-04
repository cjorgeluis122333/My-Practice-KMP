package cu.my.practice.kmp.core.network.service.user

import cu.my.practice.kmp.core.network.response.UserResponse

interface UserService {
    suspend fun getAllUserFromMyBack(): List<UserResponse>

    suspend fun getUserById(id: Int): UserResponse
}