package cu.my.practice.kmp.core.domain.usecase.pictures

import cu.my.practice.kmp.core.domain.repository.PictureRepository
import cu.my.practice.kmp.core.model.picture.Picture

class DeletePictureUsesCase(private val pictureRepository: PictureRepository) {
    suspend operator fun invoke(pictureToDelete: Picture) {
        pictureRepository.deletePicture(pictureToDelete)
    }
}