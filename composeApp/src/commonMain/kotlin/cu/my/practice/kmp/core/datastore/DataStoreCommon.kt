package cu.my.practice.kmp.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath


private lateinit var dataStore: DataStore<Preferences>

/**
 * Gets the [DataStore] instance.
 *
 * @param producePath function to produce the path to the data store file
 *
 * @return the [DataStore] instance
 */
fun getDataStore(producePath: () -> String): DataStore<Preferences> =
        if (::dataStore.isInitialized) {
            dataStore
        } else {
            PreferenceDataStoreFactory
                .createWithPath(produceFile = { producePath().toPath() })
                .also { dataStore = it }
        }

internal const val dataStoreFileName = "practice_settings.preferences_pb"
