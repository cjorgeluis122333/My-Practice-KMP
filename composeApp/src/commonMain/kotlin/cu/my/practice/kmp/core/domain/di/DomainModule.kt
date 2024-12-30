package cu.my.practice.kmp.core.domain.di

import cu.my.practice.kmp.core.domain.data.AdminRepositoryImpl
import cu.my.practice.kmp.core.domain.data.AuthRepositoryImpl
import cu.my.practice.kmp.core.domain.data.UserRepositoryImpl
import cu.my.practice.kmp.core.domain.repository.AdminRepository
import cu.my.practice.kmp.core.domain.repository.AuthRepository
import cu.my.practice.kmp.core.domain.repository.UserRepository
import cu.my.practice.kmp.core.domain.usecase.admin.DeleteUseCase
import cu.my.practice.kmp.core.domain.usecase.admin.InsertUseCase
import cu.my.practice.kmp.core.domain.usecase.admin.UpdateUseCase
import cu.my.practice.kmp.core.domain.usecase.auth.AuthUseCase
import cu.my.practice.kmp.core.domain.usecase.auth.LoginUseCase
import cu.my.practice.kmp.core.domain.usecase.auth.RegisterUseCase
import cu.my.practice.kmp.core.domain.usecase.user.FindAllUserUseCase
import cu.my.practice.kmp.core.domain.usecase.user.FindUserByUsernameUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    //Repository
    singleOf(::AdminRepositoryImpl).bind<AdminRepository>()
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
    singleOf(::UserRepositoryImpl).bind<UserRepository>()

    //UseCase
    singleOf(::AuthUseCase)
    singleOf(::LoginUseCase)
    singleOf(::RegisterUseCase)


    singleOf(::DeleteUseCase)
    singleOf(::InsertUseCase)
    singleOf(::UpdateUseCase)

    singleOf(::FindAllUserUseCase)
    singleOf(::FindUserByUsernameUseCase)


}