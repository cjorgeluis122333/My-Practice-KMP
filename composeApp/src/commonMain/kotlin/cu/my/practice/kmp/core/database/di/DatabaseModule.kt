package cu.my.practice.kmp.core.database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import cu.my.practice.kmp.core.database.DatabaseFactory
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule = module {

    //Here i provide the expect received for any platform
    includes(databasePlatformModule)
    single { get<DatabaseFactory>().create()
        .setDriver(BundledSQLiteDriver())
        .build()
    }
}

expect val databasePlatformModule:Module