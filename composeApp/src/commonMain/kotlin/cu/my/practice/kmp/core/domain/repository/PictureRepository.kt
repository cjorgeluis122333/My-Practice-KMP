package cu.my.practice.kmp.core.domain.repository

import cu.my.practice.kmp.core.model.picture.Picture
import kotlinx.coroutines.flow.Flow

interface PictureRepository {
    fun selectAllPictureDec(): Flow<List<Picture>>

    suspend fun insertPicture(picture: Picture)

    suspend fun deletePicture(picture: Picture)

}