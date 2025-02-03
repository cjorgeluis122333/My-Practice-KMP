package cu.my.practice.kmp.core.network.datasource

import cu.my.practice.kmp.core.domain.datasource.remote.UserRemoteDatasource
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.service.user.UserServiceImp

class UserRemoteDatasourceImplement(
    private val userServiceImp: UserServiceImp,
) : RemoteDatasourceAbstraction(), UserRemoteDatasource {

    override suspend fun getAllUser(): ResultValue<List<UserResponse>> = safeApiCall {
        userServiceImp.getAllUserFromMyBack()
    }

    override suspend fun getUserById(id: Int): ResultValue<UserResponse> = safeApiCall {
        userServiceImp.getUserById(id)
    }


}