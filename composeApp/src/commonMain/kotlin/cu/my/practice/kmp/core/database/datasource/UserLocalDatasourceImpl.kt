package cu.my.practice.kmp.core.database.datasource

import cu.my.practice.kmp.core.database.dao.UserDao
import cu.my.practice.kmp.core.database.mapper.toEntity
import cu.my.practice.kmp.core.database.mapper.toModel
import cu.my.practice.kmp.core.domain.datasource.local.UserLocalDatasource
import cu.my.practice.kmp.core.model.user.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserLocalDatasourceImpl(private val userDao: UserDao) : UserLocalDatasource {

    override suspend fun getUserByName(name: String): UserModel? =
        userDao.getUserByName(name)?.toModel()

    override  fun selectAllUser(): Flow<List<UserModel>> =
        userDao.selectAllUser().map { user ->
            user.map { it.toModel() }
        }

    override suspend fun insertUserEntity(userModel: UserModel) {
        userDao.insertUserEntity(userModel.toEntity())
    }


}