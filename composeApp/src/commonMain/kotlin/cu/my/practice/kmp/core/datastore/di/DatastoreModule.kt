package cu.my.practice.kmp.core.datastore.di

import cu.my.practice.kmp.core.common.Context
import cu.my.practice.kmp.core.datastore.datasource.AuthDatastoreImpl
import cu.my.practice.kmp.core.domain.datasource.local.AuthDataStore
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

fun datastoreModule(context: Context):Module = module{

}


val dataStoreModuleNotContext = module {
single { AuthDatastoreImpl(get()) }.bind<AuthDataStore>()
includes(platformDataStoreModule)
}
internal expect val platformDataStoreModule: Module
