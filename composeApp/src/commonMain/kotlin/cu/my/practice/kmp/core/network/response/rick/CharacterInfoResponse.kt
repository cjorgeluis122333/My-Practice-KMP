package cu.my.practice.kmp.core.network.response.rick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterInfoResponse(
    @SerialName("count") val count: Int,
    @SerialName("pages") val pages: Int = 42,
    @SerialName("next") val next: String? = null,
    @SerialName("prev") val prev: String? = null
)