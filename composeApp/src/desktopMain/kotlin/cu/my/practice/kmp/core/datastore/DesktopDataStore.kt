package cu.my.practice.kmp.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import java.io.File

class DesktopDataStore {
    /*
    fun getDataStore() = getDataStore(
        producePath = {
            val userHome = System.getProperty("user.home")
            Paths.get(
                userHome,
                ".config",  //This is the common rout for (Window and Mac) should have the same for all device
                dataStoreFileName
            ).toString()
        }
    )
*/

    fun createDataStore(): DataStore<Preferences> {
        val parentFolder = File(System.getProperty("user.dir"))
        if (!parentFolder.exists()) {
            parentFolder.mkdirs()
        }
        val preferencesPath = File(parentFolder, dataStoreFileName)
        return getDataStore(
            producePath = { preferencesPath.absolutePath }
        )
    }

}