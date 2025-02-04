package cu.my.practice.kmp.shared.di

import cu.my.practice.kmp.core.common.di.commonModule
import cu.my.practice.kmp.core.database.di.databaseModule
import cu.my.practice.kmp.core.datastore.di.dataStoreModuleNotContext
import cu.my.practice.kmp.core.domain.di.domainModule
import cu.my.practice.kmp.core.network.di.networkModule
import cu.my.practice.kmp.feature.admin.AdminViewModel
import cu.my.practice.kmp.feature.contact_database.ContactViewModel
import cu.my.practice.kmp.feature.home.HomeViewModel
import cu.my.practice.kmp.feature.login.LoginViewModel
import cu.my.practice.kmp.feature.register.RegisterViewModel
import cu.my.practice.kmp.feature.rick_paging.RickMortyViewModel
import cu.my.practice.kmp.shared.AppViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val sharedModule = module {

    viewModelOf(::AppViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::AdminViewModel)
    viewModelOf(::ContactViewModel)
    viewModelOf(::RickMortyViewModel)

}


fun initKoinNotContext(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(allModulesNotContext())
    }
}


fun allModulesNotContext() =
    listOf(
        commonModule,
        networkModule,
        dataStoreModuleNotContext,
        databaseModule,
        domainModule,
        sharedModule
    )