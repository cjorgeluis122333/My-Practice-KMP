package cu.my.practice.kmp.core.domain.datasource.local

import androidx.datastore.preferences.core.edit
import cu.my.practice.kmp.core.datastore.datasource.AuthDatastoreImpl.AuthKeys
import kotlinx.coroutines.flow.firstOrNull

interface AuthDataStore {
    suspend fun getUsername(): String?
    suspend fun saveUserName(value: String)

    suspend fun getToken(): String?
    suspend fun saveToken(value: String)

}