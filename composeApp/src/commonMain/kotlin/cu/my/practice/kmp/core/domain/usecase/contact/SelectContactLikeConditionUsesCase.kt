package cu.my.practice.kmp.core.domain.usecase.contact

import cu.my.practice.kmp.core.domain.repository.ContactRepository

class SelectContactLikeConditionUsesCase(
    private val contactRepository: ContactRepository
) {
}