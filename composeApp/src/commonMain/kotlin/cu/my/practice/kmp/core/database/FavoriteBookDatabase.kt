package cu.my.practice.kmp.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cu.my.practice.kmp.core.database.dao.FavoriteBookDao
import cu.my.practice.kmp.core.database.entity.BookEntity
import cu.my.practice.kmp.core.database.util.StringListTypeConverter

@Database(
    entities = [BookEntity::class],
    version = 1
)
@TypeConverters(
    StringListTypeConverter::class
)
@ConstructedBy(BookDatabaseConstructor::class)
abstract class FavoriteBookDatabase: RoomDatabase() {
    abstract val favoriteBookDao: FavoriteBookDao

    companion object {
        const val DB_NAME = "book.db"
    }
}