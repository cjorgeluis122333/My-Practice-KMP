package cu.my.practice.kmp.core.database.datasource

import cu.my.practice.kmp.core.database.dao.ContactDao
import cu.my.practice.kmp.core.database.mapper.toDataBase
import cu.my.practice.kmp.core.database.mapper.toModel
import cu.my.practice.kmp.core.domain.datasource.local.ContactDataSource
import cu.my.practice.kmp.core.model.contact.Contact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactDataSourceImpl(
    private val contactDao: ContactDao
) : ContactDataSource {

    override fun selectAllContact(): Flow<List<Contact>> =
        contactDao.selectAllContact().map { data ->
            data.map { it.toModel() }
        }

    override fun selectByNameLike(name: String): Flow<List<Contact>> =
        contactDao.selectByNameLike(name).map { data -> data.map { it.toModel() } }

    override suspend fun updateContact(contactToUpdate: Contact) =
        contactDao.updateContact(contactToUpdate.toDataBase())

    override suspend fun deleteContact(contactToDelete: Contact) =
        contactDao.deleteContact(
            contactToDelete.toDataBase()
        )

    override suspend fun insertContact(contactToInsert: Contact) {
        contactDao.insertEntity(contactToInsert.toDataBase())
    }


}