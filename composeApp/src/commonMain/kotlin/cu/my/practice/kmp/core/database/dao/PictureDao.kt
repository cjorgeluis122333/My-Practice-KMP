package cu.my.practice.kmp.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cu.my.practice.kmp.core.database.entity.PictureEntity

@Dao
interface PictureDao {

    @Query("Select * from pictures order by id desc")
    suspend fun selectAllPicture(): List<PictureEntity>

    @Insert(entity = PictureEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPicture(pictureEntity: PictureEntity)

    @Delete
    suspend fun deletePicture(pictureEntity: PictureEntity)
}