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
    fun selectAllContact(): Flow<ContactEntity>

    @Update
    suspend fun updateContact(contactToUpdate: ContactEntity): ContactEntity

    @Delete
    suspend fun deleteContact(contactToDelete: ContactEntity): ContactEntity

    @Insert
    fun contactEntity(contactToInsert: ContactEntity)

}