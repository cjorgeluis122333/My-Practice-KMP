package cu.my.practice.kmp.core.domain.datasource.local

import cu.my.practice.kmp.core.model.contact.Contact
import kotlinx.coroutines.flow.Flow

interface ContactDataSource {

    fun selectAllContact(): Flow<List<Contact>>

    suspend fun updateContact(contactToUpdate: Contact)

    suspend fun deleteContact(contactToDelete: Contact)

   suspend fun insertContact(contactToInsert: Contact)

    fun selectByNameLike(name:String):Flow<List<Contact>>


}