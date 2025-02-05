package cu.my.practice.kmp.core.domain.usecase.contact

data class ContactUsesCase(
    val selectAllContact: SelectAllContactsUsesCase,
    val selectAllContactLikeCondition: SelectContactLikeConditionUsesCase,
    val deleteContactByPosition: DeleteContactUsesCase,
    val insertContact: InsertContactUsesCase,
    val updateContact: UpdateContactUsesCase
)