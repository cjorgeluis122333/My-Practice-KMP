package cu.my.practice.kmp.core.datastore.di

import cu.my.practice.kmp.core.datastore.IosDataStore
import org.koin.dsl.module


internal actual val platformDataStoreModule = module {
    single { IosDataStore().getDataStore() }
}