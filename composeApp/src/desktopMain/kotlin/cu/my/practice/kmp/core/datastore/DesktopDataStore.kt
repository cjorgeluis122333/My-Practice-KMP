package cu.my.practice.kmp.core.datastore

import java.nio.file.Paths

class DesktopDataStore {
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
}