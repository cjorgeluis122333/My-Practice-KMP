package cu.my.practice.kmp.core.database.di

import cu.my.practice.kmp.core.database.DatabaseFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databasePlatformModule: Module
    get() = module {
        single { DatabaseFactory() }
    }