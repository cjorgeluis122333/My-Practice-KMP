package cu.my.practice.kmp.core.database.datasource

import cu.my.practice.kmp.core.database.dao.PictureDao
import cu.my.practice.kmp.core.database.mapper.toEntity
import cu.my.practice.kmp.core.database.mapper.toModel
import cu.my.practice.kmp.core.domain.datasource.local.PictureDataSource
import cu.my.practice.kmp.core.model.picture.Picture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PictureDataSourceImplement(private val pictureDao: PictureDao) : PictureDataSource {
    override fun selectAllPictureDec(): Flow<List<Picture>> =
        pictureDao.selectAllPicture().map { picture -> picture.map { it.toModel() } }


    override suspend fun insertPicture(picture: Picture) {
        pictureDao.insertPicture(picture.toEntity())
    }

    override suspend fun deletePicture(picture: Picture) {
        pictureDao.deletePicture(picture.toEntity())
    }
}