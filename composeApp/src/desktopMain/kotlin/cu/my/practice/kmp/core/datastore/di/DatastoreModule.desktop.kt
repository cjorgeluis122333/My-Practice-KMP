package cu.my.practice.kmp.core.datastore.di

import cu.my.practice.kmp.core.datastore.DesktopDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformDataStoreModule: Module
    get() = module {
        single {
            DesktopDataStore().createDataStore()
        }
    }