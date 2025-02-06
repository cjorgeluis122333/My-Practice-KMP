package cu.my.practice.kmp.core.network.service.network

import cu.my.practice.kmp.core.network.response.rick.CharacterWrapper
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class RickServiceImpl(
    private val client: HttpClient
) : RickService {

   override suspend fun getCharacters(page: Int): CharacterWrapper =
        client.get("http://rickandmortyapi.com/api/character/") {
            parameter("page", page)
        }.body()

}