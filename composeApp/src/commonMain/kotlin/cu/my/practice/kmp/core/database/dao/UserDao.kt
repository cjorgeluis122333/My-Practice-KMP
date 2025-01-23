package cu.my.practice.kmp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cu.my.practice.kmp.core.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity WHERE name = :name")
    suspend fun getUserByName(name: String): UserEntity?

    @Query("SELECT * FROM UserEntity")
    fun selectAllUser(): Flow<List<UserEntity>>

    @Insert(entity = UserEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserEntity(userModel: UserEntity)
}