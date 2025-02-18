package cu.my.practice.kmp.core.domain.datasource.local

import cu.my.practice.kmp.core.model.picture.Picture
import kotlinx.coroutines.flow.Flow

interface PictureDataSource {

    fun selectAllPictureDec(): Flow<List<Picture>>

    suspend fun insertPicture(picture: Picture)

    suspend fun deletePicture(picture: Picture)
}