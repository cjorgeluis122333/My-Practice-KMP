package cu.my.practice.kmp.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import cu.my.practice.kmp.core.common.Context
import cu.my.practice.kmp.core.datastore.util.APP_DATASTORE
import kotlinx.coroutines.flow.firstOrNull

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(APP_DATASTORE)

//                   String preferences key
actual suspend fun Context.getData(key: String): String? =
    dataStore.data.firstOrNull()?.get(stringPreferencesKey(key))



actual suspend fun Context.saveData(key: String, `object`: String) {
    dataStore.edit {
        it[stringPreferencesKey(key)] = `object`
    }
}

//                   Boolean preferences key
actual suspend fun Context.getDataBoolean(key: String): Boolean? =
    dataStore.data.firstOrNull()?.get(booleanPreferencesKey(key))


actual suspend fun Context.saveDataBoolean(key: String, value: Boolean) {
    dataStore.edit { it[booleanPreferencesKey(key)] = value }
}
