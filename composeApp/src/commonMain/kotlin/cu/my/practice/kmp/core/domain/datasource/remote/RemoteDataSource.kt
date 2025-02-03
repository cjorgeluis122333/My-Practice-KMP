package cu.my.practice.kmp.core.domain.datasource.remote

import cu.my.practice.kmp.core.model.ResultValue


interface RemoteDataSource {
    suspend fun <T : Any> safeApiCall(request: suspend () -> T): ResultValue<T>
}