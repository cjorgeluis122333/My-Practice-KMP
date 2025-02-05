package cu.my.practice.kmp.core.database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import cu.my.practice.kmp.core.database.DatabaseFactory
import cu.my.practice.kmp.core.database.MyPracticeDatabase
import cu.my.practice.kmp.core.database.datasource.ContactDataSourceImpl
import cu.my.practice.kmp.core.database.datasource.UserLocalDatasourceImpl
import cu.my.practice.kmp.core.domain.datasource.local.ContactDataSource
import cu.my.practice.kmp.core.domain.datasource.local.UserLocalDatasource
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {

    //Here i provide the expect received for any platform
    //                       Generate the database
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .fallbackToDestructiveMigration(dropAllTables = false)  //Clear and rebuild al tables but all start empty
            .build()
    }

    //                      Provide the dao
    single { get<MyPracticeDatabase>().favoriteBookDao }
    single { get<MyPracticeDatabase>().userDao }
    single { get<MyPracticeDatabase>().contactDao }

    //                      Datasource
    singleOf(::UserLocalDatasourceImpl).bind<UserLocalDatasource>()
    singleOf(::ContactDataSourceImpl).bind<ContactDataSource>()

    //Platform Modules
    includes(databasePlatformModule)

}

expect val databasePlatformModule: Module