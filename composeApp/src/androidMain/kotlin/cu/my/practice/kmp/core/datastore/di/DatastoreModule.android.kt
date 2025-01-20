package cu.my.practice.kmp.core.datastore.di

import cu.my.practice.kmp.core.datastore.AndroidDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformDataStoreModule: Module
    get() = module {
        single {
            AndroidDataStore(context = get()).getDataStore()
        }
    }