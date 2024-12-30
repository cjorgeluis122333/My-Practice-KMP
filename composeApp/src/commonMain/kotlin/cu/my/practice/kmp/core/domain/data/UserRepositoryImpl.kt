package cu.my.practice.kmp.core.domain.data

import cu.my.practice.kmp.core.domain.repository.UserRepository
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse

class UserRepositoryImpl():UserRepository {

    override suspend fun findUsers(): ResultValue<List<UserResponse>> {
        TODO("Not yet implemented")
    }

    override suspend fun findUserByUsername(): ResultValue<UserResponse> {
        TODO("Not yet implemented")
    }

}