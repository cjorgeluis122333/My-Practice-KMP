package cu.my.practice.kmp.feature.gallery_database

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cu.my.practice.kmp.core.domain.usecase.pictures.DeletePictureUsesCase
import cu.my.practice.kmp.core.domain.usecase.pictures.InsertPictureUsesCase
import cu.my.practice.kmp.core.domain.usecase.pictures.SelectPictureUsesCase
import cu.my.practice.kmp.core.model.picture.Picture
import cu.my.practice.kmp.feature.gallery_database.state.GalleryEventState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GalleryViewModel(
    selectPictureUsesCase: SelectPictureUsesCase,
    private val insertPictureUsesCase: InsertPictureUsesCase,
    private val deletePictureUsesCase: DeletePictureUsesCase
) : ViewModel() {


    val allPicture = selectPictureUsesCase().stateIn(
        initialValue = emptyList(),
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000)
    )


    fun onEvent(pictureEventState: GalleryEventState) {
        when (pictureEventState) {
            is GalleryEventState.OnDelete -> {
                viewModelScope.launch {
                    deletePictureUsesCase(pictureEventState.imageToDelete)
                }
            }

            is GalleryEventState.OnInsert -> {
                viewModelScope.launch {
                    insertPictureUsesCase(pictureEventState.imageToInsert)
                }
            }
        }
    }

//    private val _pictures: MutableStateFlow<SnapshotStateList<Picture>> =
//        MutableStateFlow(mutableStateListOf())
//    val pictures = _pictures.asStateFlow()


}