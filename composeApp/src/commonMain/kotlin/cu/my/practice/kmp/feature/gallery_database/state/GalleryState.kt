package cu.my.practice.kmp.feature.gallery_database.state

import cu.my.practice.kmp.core.model.picture.Picture
import org.jetbrains.compose.resources.StringResource

data class GalleryState(
    val pictures: List<Picture> = emptyList(),
    val error: StringResource? = null,
    val loading: Boolean = true
)