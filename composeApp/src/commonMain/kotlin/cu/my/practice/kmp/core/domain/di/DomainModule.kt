package cu.my.practice.kmp.core.domain.di

import cu.my.practice.kmp.core.domain.data.AdminRepositoryImpl
import cu.my.practice.kmp.core.domain.data.AuthRepositoryImpl
import cu.my.practice.kmp.core.domain.data.ContactRepositoryImpl
import cu.my.practice.kmp.core.domain.data.HomeRepositoryImpl
import cu.my.practice.kmp.core.domain.data.UserRepositoryImpl
import cu.my.practice.kmp.core.domain.repository.AdminRepository
import cu.my.practice.kmp.core.domain.repository.AuthRepository
import cu.my.practice.kmp.core.domain.repository.ContactRepository
import cu.my.practice.kmp.core.domain.repository.HomeRepository
import cu.my.practice.kmp.core.domain.repository.UserRepository
import cu.my.practice.kmp.core.domain.usecase.admin.DeleteUseCase
import cu.my.practice.kmp.core.domain.usecase.admin.InsertUseCase
import cu.my.practice.kmp.core.domain.usecase.admin.UpdateUseCase
import cu.my.practice.kmp.core.domain.usecase.auth.AuthUseCase
import cu.my.practice.kmp.core.domain.usecase.auth.LoginUseCase
import cu.my.practice.kmp.core.domain.usecase.auth.RegisterUseCase
import cu.my.practice.kmp.core.domain.usecase.contact.ContactUsesCase
import cu.my.practice.kmp.core.domain.usecase.contact.DeleteContactUsesCase
import cu.my.practice.kmp.core.domain.usecase.contact.InsertContactUsesCase
import cu.my.practice.kmp.core.domain.usecase.contact.SelectAllContactsUsesCase
import cu.my.practice.kmp.core.domain.usecase.contact.SelectContactLikeConditionUsesCase
import cu.my.practice.kmp.core.domain.usecase.contact.UpdateContactUsesCase
import cu.my.practice.kmp.core.domain.usecase.user.FindAllUserUseCase
import cu.my.practice.kmp.core.domain.usecase.user.FindUserByUsernameUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {


    //===============================================         Repository

    singleOf(::AdminRepositoryImpl).bind<AdminRepository>()
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
    singleOf(::UserRepositoryImpl).bind<UserRepository>()
    singleOf(::HomeRepositoryImpl).bind<HomeRepository>()
    singleOf(::ContactRepositoryImpl).bind<ContactRepository>()

    // ==============================================         UseCase
    //Auth
    singleOf(::AuthUseCase)
    singleOf(::LoginUseCase)
    singleOf(::RegisterUseCase)

    //Contact
    singleOf(::ContactUsesCase)
    singleOf(::SelectContactLikeConditionUsesCase)
    singleOf(::SelectAllContactsUsesCase)
    singleOf(::InsertContactUsesCase)
    singleOf(::UpdateContactUsesCase)
    singleOf(::DeleteContactUsesCase)

    //Admin
    singleOf(::DeleteUseCase)
    singleOf(::InsertUseCase)
    singleOf(::UpdateUseCase)

    //Test
    singleOf(::FindAllUserUseCase)
    singleOf(::FindUserByUsernameUseCase)


}