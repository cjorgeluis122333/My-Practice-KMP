package cu.my.practice.kmp.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cu.my.practice.kmp.core.database.dao.ContactDao
import cu.my.practice.kmp.core.database.dao.FavoriteBookDao
import cu.my.practice.kmp.core.database.dao.PictureDao
import cu.my.practice.kmp.core.database.dao.UserDao
import cu.my.practice.kmp.core.database.entity.BookEntity
import cu.my.practice.kmp.core.database.entity.ContactEntity
import cu.my.practice.kmp.core.database.entity.PictureEntity
import cu.my.practice.kmp.core.database.entity.UserEntity
import cu.my.practice.kmp.core.database.util.type.PictureConverter
import cu.my.practice.kmp.core.database.util.type.StringListTypeConverter

@Database(
    entities = [BookEntity::class, UserEntity::class, ContactEntity::class, PictureEntity::class],
    version = 4,
    //exportSchema = true,
    //   autoMigrations = [AutoMigration(from = 1, to = 2 , spec = MyPracticeDatabase.MyAutoMigration::class)]
)
@TypeConverters(value = [StringListTypeConverter::class, PictureConverter::class])
@ConstructedBy(BookDatabaseConstructor::class)

abstract class MyPracticeDatabase : RoomDatabase() {

    // @DeleteTable(tableName = "values_table")
    //  class MyAutoMigration : AutoMigrationSpec


    abstract val favoriteBookDao: FavoriteBookDao
    abstract val userDao: UserDao
    abstract val contactDao: ContactDao
    abstract val pictureDao: PictureDao

    companion object {
        const val DB_NAME = "book.db"
        const val DIRECTORY_NAME_DESKTOP = "Bookpedia"
    }
}
