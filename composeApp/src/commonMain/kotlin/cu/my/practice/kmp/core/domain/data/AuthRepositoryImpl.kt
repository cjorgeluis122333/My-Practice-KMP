package cu.my.practice.kmp.core.domain.data

import cu.my.practice.kmp.core.common.Coroutine
import cu.my.practice.kmp.core.domain.datasource.local.AuthDataStore
import cu.my.practice.kmp.core.domain.datasource.remote.AuthRemoteDataSource
import cu.my.practice.kmp.core.domain.repository.AuthRepository
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(
    private val authDataStore: AuthDataStore,
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val ioDispatcher: Coroutine
) : AuthRepository {
    override suspend fun postLogin(userToLogin: UserLoginRequest): ResultValue<UserLoginResponse> =
        withContext(ioDispatcher.ioDispatcher) {
            authRemoteDataSource.postLogin(userToLogin)
        }

    override suspend fun postRegister(userToRegister: UserResponse): ResultValue<UserResponse> =
        withContext(ioDispatcher.ioDispatcher) {
            authRemoteDataSource.postRegister(userToRegister)
        }

    override suspend fun getUserName(): String? = withContext(ioDispatcher.ioDispatcher) {
        authDataStore.getUsername()
    }

    override suspend fun getToken(): String? = withContext(ioDispatcher.ioDispatcher) {
        authDataStore.getToken()
    }

    override suspend fun saveUserName(name: String) = withContext(ioDispatcher.ioDispatcher) {
        authDataStore.saveUserName(name)
    }

    override suspend fun saveToken(token: String) = withContext(ioDispatcher.ioDispatcher) {
        authDataStore.saveToken(token)
    }
}