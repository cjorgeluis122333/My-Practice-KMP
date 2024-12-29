package cu.my.practice.kmp.core.network.service.admin

import cu.my.practice.kmp.core.network.response.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AdminServiceImp(
    private val httpClient: HttpClient
) :AdminService {

   override suspend fun updateUser(userToUpdate: UserResponse): UserResponse {
        return httpClient.post("/register") {
            setBody(userToUpdate)
        }.body()
    }


   override suspend fun insertUser(userToUpdate: UserResponse): UserResponse {
        return httpClient.post("/register") {
            contentType(ContentType.Application.Json)
            setBody(userToUpdate)
        }.body()
    }

   override suspend fun deleteUser(id: Int): Boolean {
        return httpClient.post("/user${id}").body()
    }

}