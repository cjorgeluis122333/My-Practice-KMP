package cu.my.practice.kmp.core.datastore.di

import cu.my.practice.kmp.core.datastore.datasource.AuthDatastoreImpl
import cu.my.practice.kmp.core.domain.datasource.local.AuthDataStore
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module



val dataStoreModuleNotContext = module {
    //Instances data store
    includes(platformDataStoreModule)

    // Data store services
    single { AuthDatastoreImpl(get()) }.bind<AuthDataStore>()

}
internal expect val platformDataStoreModule: Module
