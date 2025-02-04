package cu.my.practice.kmp.core.network.response.rick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CharacterLocation(
  @SerialName("name")  val name:String
)