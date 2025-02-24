package cu.my.practice.kmp.feature.gallery_database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cu.my.practice.kmp.core.domain.usecase.pictures.DeletePictureUsesCase
import cu.my.practice.kmp.core.domain.usecase.pictures.InsertPictureUsesCase
import cu.my.practice.kmp.core.domain.usecase.pictures.SelectPictureUsesCase
import cu.my.practice.kmp.core.model.picture.Picture
import cu.my.practice.kmp.feature.gallery_database.state.GalleryEventState
import cu.my.practice.kmp.feature.gallery_database.state.GalleryState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource

class GalleryViewModel(
    private val selectPictureUsesCase: SelectPictureUsesCase,
    private val insertPictureUsesCase: InsertPictureUsesCase,
    private val deletePictureUsesCase: DeletePictureUsesCase
) : ViewModel() {

    private val _state: MutableStateFlow<GalleryState> = MutableStateFlow(GalleryState())
    val state = _state.asStateFlow()

    init {
        loadPictures()
    }
//    val allPicture = selectPictureUsesCase().stateIn(
//        initialValue = emptyList(),
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000)
//    )


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

    private fun loadPictures() {
        viewModelScope.launch {
            stateHandler(isLoading = true)
            stateHandler(pictures = selectPictureUsesCase())
            stateHandler(isLoading = false)
        }

    }

    private fun stateHandler(
        pictures: List<Picture> = _state.value.pictures,
        error: StringResource? = null,
        isLoading: Boolean = _state.value.loading
    ) {
        _state.update {
            it.copy(
                pictures = pictures,
                error = error,
                loading = isLoading
            )
        }

    }

}//End viewmodel