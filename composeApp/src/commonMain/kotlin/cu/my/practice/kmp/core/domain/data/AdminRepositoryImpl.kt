package cu.my.practice.kmp.core.domain.data

import cu.my.practice.kmp.core.domain.repository.AdminRepository
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse

class AdminRepositoryImpl():AdminRepository {
    override suspend fun findUsers(): ResultValue<List<UserResponse>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(): ResultValue<UserResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun insertUser(): ResultValue<UserResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(): ResultValue<Boolean> {
        TODO("Not yet implemented")
    }

}