package cu.my.practice.kmp.core.database.mapper

import cu.my.practice.kmp.core.database.entity.ContactEntity
import cu.my.practice.kmp.core.model.contact.Contact

fun ContactEntity.toModel() = Contact(
    lastName = lastName,
    city = city,
    firstName = firstName,
    fontNumber = fontNumber
)


fun Contact.toDataBase() = ContactEntity(
    lastName = lastName,
    city = city,
    firstName = firstName,
    fontNumber = fontNumber
)