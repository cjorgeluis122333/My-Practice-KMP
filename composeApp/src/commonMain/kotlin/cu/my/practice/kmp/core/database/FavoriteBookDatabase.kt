package cu.my.practice.kmp.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cu.my.practice.kmp.core.database.dao.FavoriteBookDao
import cu.my.practice.kmp.core.database.dao.UserDao
import cu.my.practice.kmp.core.database.entity.BookEntity
import cu.my.practice.kmp.core.database.entity.UserEntity
import cu.my.practice.kmp.core.database.util.StringListTypeConverter

@Database(
    entities = [BookEntity::class, UserEntity::class],
    version = 3,
    //exportSchema = true,
    //   autoMigrations = [AutoMigration(from = 1, to = 2 , spec = FavoriteBookDatabase.MyAutoMigration::class)]
)
@TypeConverters(StringListTypeConverter::class)
@ConstructedBy(BookDatabaseConstructor::class)
abstract class FavoriteBookDatabase : RoomDatabase() {

    // @DeleteTable(tableName = "values_table")
    //  class MyAutoMigration : AutoMigrationSpec


    abstract val favoriteBookDao: FavoriteBookDao
    abstract val userDao: UserDao

    companion object {
        const val DB_NAME = "book.db"
        const val DIRECTORY_NAME_DESKTOP = "Bookpedia"
    }
}
