package cu.my.practice.kmp.core.network.service.auth

import cu.my.practice.kmp.core.network.response.UserResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthServiceImp(private val client: HttpClient): AuthService {

   override suspend fun login(userLoginRequest: UserLoginRequest): UserLoginResponse {
        return client.post("/login") {
            contentType(type = ContentType.Application.Json)
            setBody(userLoginRequest)
        }.body()
    }

   override suspend fun register(userToRegister:UserResponse):UserResponse{
        return client.post("/api/register"){
            contentType(ContentType.Application.Json)
            setBody(userToRegister)
        }.body()
    }

}
