package cu.my.practice.kmp.core.domain.data

import cu.my.practice.kmp.core.common.Coroutine
import cu.my.practice.kmp.core.domain.datasource.local.ContactDataSource
import cu.my.practice.kmp.core.domain.repository.ContactRepository
import cu.my.practice.kmp.core.model.contact.Contact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class ContactRepositoryImpl(
    private val contactDataSource: ContactDataSource,
    private val ioDispatcher: Coroutine
) : ContactRepository {
    override fun selectAllContact(): Flow<List<Contact>> =
        contactDataSource.selectAllContact().flowOn(ioDispatcher.ioDispatcher)

    override suspend fun updateContact(contactToUpdate: Contact)=
        withContext(ioDispatcher.ioDispatcher) {
            contactDataSource.updateContact(contactToUpdate)
        }

    override suspend fun deleteContact(contactToDelete: Contact) =
        withContext(ioDispatcher.ioDispatcher) {
            contactDataSource.deleteContact(contactToDelete)
        }

    override suspend fun insertContact(contactToInsert: Contact) {
        withContext(ioDispatcher.ioDispatcher) {
            contactDataSource.insertContact(contactToInsert)
        }
    }

    override fun selectByNameLike(name: String): Flow<List<Contact>> {
        TODO("Not yet implemented")
    }
}