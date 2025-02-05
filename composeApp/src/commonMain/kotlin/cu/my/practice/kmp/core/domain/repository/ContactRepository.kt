package cu.my.practice.kmp.core.domain.repository

import cu.my.practice.kmp.core.model.contact.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun selectAllContact(): Flow<List<Contact>>

    suspend fun updateContact(contactToUpdate: Contact)

    suspend fun deleteContact(contactToDelete: Contact)

   suspend fun insertContact(contactToInsert: Contact)

    fun selectByNameLike(name: String): Flow<List<Contact>>

}