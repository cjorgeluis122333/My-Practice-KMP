package cu.my.practice.kmp.core.database.mapper

import cu.my.practice.kmp.core.common.util.toByteArray
import cu.my.practice.kmp.core.common.util.toImageBitmap
import cu.my.practice.kmp.core.database.entity.PictureEntity
import cu.my.practice.kmp.core.model.picture.Picture

fun Picture.toEntity(): PictureEntity {
    return PictureEntity(
        image = imageBitmap?.toByteArray()
    )
}

fun PictureEntity.toModel(): Picture = Picture(
    imageBitmap = image?.toImageBitmap()
)


