package cu.my.practice.kmp.core.domain.usecase.contact

import cu.my.practice.kmp.core.domain.repository.ContactRepository

class UpdateContactUsesCase(
    private val contactRepository: ContactRepository
) {
}