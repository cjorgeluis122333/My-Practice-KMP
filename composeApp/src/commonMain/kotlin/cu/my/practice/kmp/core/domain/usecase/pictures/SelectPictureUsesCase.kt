package cu.my.practice.kmp.core.domain.usecase.pictures

import cu.my.practice.kmp.core.domain.repository.PictureRepository
import cu.my.practice.kmp.core.model.picture.Picture

class SelectPictureUsesCase(private val pictureRepository: PictureRepository) {
    suspend operator fun invoke(): List<Picture> = pictureRepository.selectAllPictureDec()
}