package cu.my.practice.kmp.core.domain.usecase.contact

import cu.my.practice.kmp.core.domain.repository.ContactRepository

class SelectAllContactsUsesCase(
   private val contactRepository: ContactRepository
) {
}