package cu.my.practice.kmp.core.datastore.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import cu.my.practice.kmp.core.domain.datasource.local.AuthDataStore
import kotlinx.coroutines.flow.firstOrNull

class AuthDatastoreImpl(
    private val datastore: DataStore<Preferences>
) :AuthDataStore{

    object AuthKeys {
        val username: Preferences.Key<String> = stringPreferencesKey("username.datastore")
        val token = stringPreferencesKey("token.datastore")
    }

   override suspend fun getUsername(): String? = datastore.data.firstOrNull()?.get(AuthKeys.username)

    override  suspend fun saveUserName(value: String) {
        datastore.edit {
            it[AuthKeys.username] = value
        }

    }

    override  suspend fun getToken(): String? = datastore.data.firstOrNull()?.get(AuthKeys.token)

    override  suspend fun saveToken(value: String) {
        datastore.edit {
            it[AuthKeys.token] = value
        }

    }


}