package cu.my.practice.kmp.core.network.service.user

import cu.my.practice.kmp.core.network.response.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserServiceImp(private val httpClient: HttpClient):UserService {
   override suspend fun getAllUserFromMyBack(): List<UserResponse> {
        return httpClient.get("/allUsers").body()
    }

   override suspend fun getUserById(id: Int): UserResponse {
        return httpClient.get("/user$id").body()
    }


}