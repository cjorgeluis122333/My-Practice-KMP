package cu.my.practice.kmp.core.network.response.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserLoginResponse(
    @SerialName("username") val username:String,
    @SerialName("message") val message:String,
    @SerialName("token") val token:String
)