package cu.my.practice.kmp.core.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("username") val username:String,
    @SerialName("lastName") val lastName:String,
   // @SerialName("password") val password:String?,
    @SerialName("email") val email:String,
//    @SerialName("phone")val phone:String,
  //  @SerialName("isAdmin") val isAdmin:Boolean = false,
   // @SerialName("enabled") val enabled:Boolean = false,
    )