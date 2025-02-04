package cu.my.practice.kmp.core.network.mapper

import cu.my.practice.kmp.core.model.character.CharacterDataModel
import cu.my.practice.kmp.core.model.character.CharacterInfoModel
import cu.my.practice.kmp.core.model.character.CharacterModel
import cu.my.practice.kmp.core.model.character.DataModel
import cu.my.practice.kmp.core.model.character.DrawableModel
import cu.my.practice.kmp.core.model.character.LocationModel
import cu.my.practice.kmp.core.network.response.rick.CharacterData
import cu.my.practice.kmp.core.network.response.rick.CharacterDataResponse
import cu.my.practice.kmp.core.network.response.rick.CharacterDrawable
import cu.my.practice.kmp.core.network.response.rick.CharacterInfoResponse
import cu.my.practice.kmp.core.network.response.rick.CharacterLocation
import cu.my.practice.kmp.core.network.response.rick.CharacterWrapper

fun CharacterWrapper.toModel(): CharacterModel =
    CharacterModel(
        info = info.toModel(),
        results = results.map { it.toModel() }
    )

fun CharacterInfoResponse.toModel(): CharacterInfoModel = CharacterInfoModel(
    next = next,
    prev = prev,
    count = count,
    pages = pages
)

fun CharacterDataResponse.toModel(): CharacterDataModel = CharacterDataModel(
    data = data.toModel(),
    drawable = drawable.toModel(),
    location = location.toModel()
)

fun CharacterData.toModel(): DataModel = DataModel(
    name = name,
    id = id,
    status = status
)

fun CharacterDrawable.toModel(): DrawableModel = DrawableModel(
    image = image
)

fun CharacterLocation.toModel(): LocationModel = LocationModel(
    name = name
)