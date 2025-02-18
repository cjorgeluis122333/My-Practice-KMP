package cu.my.practice.kmp.core.domain.usecase.pictures

import cu.my.practice.kmp.core.domain.repository.PictureRepository
import cu.my.practice.kmp.core.model.picture.Picture
import kotlinx.coroutines.flow.Flow

class SelectPictureUsesCase(private val pictureRepository: PictureRepository) {
    operator fun invoke():Flow<List<Picture>> = pictureRepository.selectAllPictureDec()
}