package cu.my.practice.kmp.core.domain.datasource.local

import cu.my.practice.kmp.core.model.user.UserModel
import kotlinx.coroutines.flow.Flow

interface UserLocalDatasource {

    suspend fun getUserByName(name: String): UserModel?

     fun selectAllUser(): Flow<List<UserModel>>

    suspend fun insertUserEntity(userModel: UserModel)

}