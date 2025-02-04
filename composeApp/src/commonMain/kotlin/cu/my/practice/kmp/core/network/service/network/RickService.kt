package cu.my.practice.kmp.core.network.service.network

import cu.my.practice.kmp.core.network.response.rick.CharacterWrapper

interface RickService {
    suspend fun getCharacters(page: Int): CharacterWrapper

}