package cu.my.practice.kmp.core.network.response.rick

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDataResponse(
    val location: CharacterLocation,
    val data: CharacterData,
    val drawable: CharacterDrawable
)