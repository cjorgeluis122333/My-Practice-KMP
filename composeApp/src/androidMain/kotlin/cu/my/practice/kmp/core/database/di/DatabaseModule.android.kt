package cu.my.practice.kmp.core.database.di

import cu.my.practice.kmp.core.database.DatabaseFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databasePlatformModule: Module= module {
    single { DatabaseFactory(androidApplication()) }
}