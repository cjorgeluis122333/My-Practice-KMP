package cu.my.practice.kmp.feature.gallery_database.state

import cu.my.practice.kmp.core.model.picture.Picture

sealed interface GalleryEventState {
   // data object OnSelectAll : GalleryEventState
    data class OnDelete(val imageToDelete: Picture) : GalleryEventState
    data class OnInsert(val imageToInsert: Picture) : GalleryEventState
}