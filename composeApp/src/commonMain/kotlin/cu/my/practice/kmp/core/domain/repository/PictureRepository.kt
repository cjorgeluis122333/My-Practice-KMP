package cu.my.practice.kmp.core.domain.repository

import cu.my.practice.kmp.core.model.picture.Picture

interface PictureRepository {
    suspend fun selectAllPictureDec(): List<Picture>

    suspend fun insertPicture(picture: Picture)

    suspend fun deletePicture(picture: Picture)

}