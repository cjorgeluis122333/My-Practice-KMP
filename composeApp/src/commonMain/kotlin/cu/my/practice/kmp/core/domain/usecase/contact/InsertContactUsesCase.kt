package cu.my.practice.kmp.core.domain.usecase.contact

import cu.my.practice.kmp.core.domain.repository.ContactRepository

class InsertContactUsesCase (
    private val contactRepository: ContactRepository
){
}