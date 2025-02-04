package cu.my.practice.kmp.core.network.response.rick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterWrapper(
    @SerialName("info") val info: CharacterInfoResponse,
    @SerialName("results") val results: List<CharacterDataResponse>
)