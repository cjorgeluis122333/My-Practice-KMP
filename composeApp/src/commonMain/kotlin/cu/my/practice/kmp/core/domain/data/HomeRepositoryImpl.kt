package cu.my.practice.kmp.core.domain.data

import cu.my.practice.kmp.core.common.Coroutine
import cu.my.practice.kmp.core.domain.datasource.local.UserLocalDatasource
import cu.my.practice.kmp.core.domain.repository.HomeRepository
import cu.my.practice.kmp.core.model.user.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class HomeRepositoryImpl(private val userLocalDatasource: UserLocalDatasource,private val coroutine: Coroutine):HomeRepository {
    override suspend fun getUserByName(name: String): UserModel? = withContext(coroutine.ioDispatcher){
        userLocalDatasource.getUserByName(name)
    }

    override  fun selectAllUser(): Flow<List<UserModel>> = userLocalDatasource.selectAllUser().flowOn(coroutine.ioDispatcher)


    override suspend fun insertUserEntity(userModel: UserModel)  = withContext(coroutine.ioDispatcher){
        userLocalDatasource.insertUserEntity(userModel = userModel)
    }

}