package cu.my.practice.kmp.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual class DatabaseFactory {

    actual fun create(): RoomDatabase.Builder<MyPracticeDatabase> {

        val os = System.getProperty("os.name")
            .lowercase()   //Get the name of the operative system in lowercase
        val userHome =
            System.getProperty("user.home")   //C:\Users\tu_usuario en Windows  <-------> /home/tu_usuario en Linux
        val appDataDir = when {
            os.contains("win") -> File(
                System.getenv("APPDATA"),  //APPDATA-> C:\Users\tu_usuario\AppData\Roaming
                MyPracticeDatabase.DIRECTORY_NAME_DESKTOP //C:\Users\tu_usuario\AppData\Roaming\DIRECTORY_NAME_DESKTOP
            )//Get the directory in this root

            os.contains("mac") -> File(
                userHome,
                "Library/Application Support/${MyPracticeDatabase.DIRECTORY_NAME_DESKTOP}"
            )

            else -> File(userHome, ".local/share/${MyPracticeDatabase.DIRECTORY_NAME_DESKTOP}")
        }

        if (!appDataDir.exists()) //If the directory doesn't exist, create it
            appDataDir.mkdirs()

        val dbFile = File(
            appDataDir, //System operative
            MyPracticeDatabase.DB_NAME  //Data base name
        )  //Define the physical file database used the name provide for: MyPracticeDatabase.DB_NAME
        return Room.databaseBuilder(dbFile.absolutePath)

    }
}