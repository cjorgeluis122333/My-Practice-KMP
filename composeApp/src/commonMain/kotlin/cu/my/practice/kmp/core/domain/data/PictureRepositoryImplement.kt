package cu.my.practice.kmp.core.domain.data

import cu.my.practice.kmp.core.common.Coroutine
import cu.my.practice.kmp.core.domain.datasource.local.PictureDataSource
import cu.my.practice.kmp.core.domain.repository.PictureRepository
import cu.my.practice.kmp.core.model.picture.Picture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class PictureRepositoryImplement(
    private val dispatcher: Coroutine,
    private val pictureDataSource: PictureDataSource
) : PictureRepository {

    override suspend fun selectAllPictureDec(): List<Picture> = withContext(dispatcher.ioDispatcher){
        pictureDataSource.selectAllPictureDec()
    }
    override suspend fun insertPicture(picture: Picture) =
        withContext(dispatcher.ioDispatcher) {
            pictureDataSource.insertPicture(picture)
        }


    override suspend fun deletePicture(picture: Picture) = withContext(dispatcher.ioDispatcher) {
        pictureDataSource.deletePicture(picture)
    }

}