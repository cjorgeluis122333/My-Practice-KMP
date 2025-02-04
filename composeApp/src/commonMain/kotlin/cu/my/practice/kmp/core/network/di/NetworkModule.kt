package cu.my.practice.kmp.core.network.di

import cu.my.practice.kmp.core.domain.datasource.remote.AuthRemoteDataSource
import cu.my.practice.kmp.core.domain.datasource.remote.RickRemoteDataSource
import cu.my.practice.kmp.core.domain.datasource.remote.UserRemoteDatasource
import cu.my.practice.kmp.core.network.client.AuthClientProvider
import cu.my.practice.kmp.core.network.client.NetworkClientProvider
import cu.my.practice.kmp.core.network.client.UserClientProvider
import cu.my.practice.kmp.core.network.datasource.AuthRemoteDataSourceImpl
import cu.my.practice.kmp.core.network.datasource.RickRemoteDataSourceImpl
import cu.my.practice.kmp.core.network.datasource.UserRemoteDatasourceImplement
import cu.my.practice.kmp.core.network.service.auth.AuthService
import cu.my.practice.kmp.core.network.service.auth.AuthServiceImp
import cu.my.practice.kmp.core.network.service.network.RickService
import cu.my.practice.kmp.core.network.service.network.RickServiceImpl
import cu.my.practice.kmp.core.network.service.user.UserService
import cu.my.practice.kmp.core.network.service.user.UserServiceImp
import cu.my.practice.kmp.core.network.util.authQualifier
import cu.my.practice.kmp.core.network.util.networkQualifier
import cu.my.practice.kmp.core.network.util.userQualifier
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    //Client
    single<HttpClient>(userQualifier) { UserClientProvider.createClient() }
    single<HttpClient>(authQualifier) { AuthClientProvider.createClient() }
    single<HttpClient>(networkQualifier) { NetworkClientProvider.createClient() }

    //Service
    single { UserServiceImp(get(userQualifier)) }.bind<UserService>()
    single { AuthServiceImp(get(authQualifier)) }.bind<AuthService>()
    single { RickServiceImpl(get(networkQualifier)) }.bind<RickService>()

    //Datasource
    singleOf(::UserRemoteDatasourceImplement).bind<UserRemoteDatasource>()
    singleOf(::AuthRemoteDataSourceImpl).bind<AuthRemoteDataSource>()
    singleOf(::RickRemoteDataSourceImpl).bind<RickRemoteDataSource>()
}