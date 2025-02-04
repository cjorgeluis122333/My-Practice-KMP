package cu.my.practice.kmp.core.network.response.rick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CharacterDrawable (
    @SerialName("image") val image:String
)