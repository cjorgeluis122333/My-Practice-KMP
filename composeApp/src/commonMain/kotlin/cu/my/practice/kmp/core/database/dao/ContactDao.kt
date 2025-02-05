package cu.my.practice.kmp.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import cu.my.practice.kmp.core.database.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("Select * from ContactEntity")
    fun selectAllContact(): Flow<List<ContactEntity>>

    @Query("Select * from ContactEntity where first_name LIKE :name")
    fun selectByNameLike(name:String):Flow<List<ContactEntity>>

    @Update
    suspend fun updateContact(contactToUpdate: ContactEntity)

    @Delete
    suspend fun deleteContact(contactToDelete: ContactEntity)

    @Insert
    fun insertEntity(contactToInsert: ContactEntity)

}