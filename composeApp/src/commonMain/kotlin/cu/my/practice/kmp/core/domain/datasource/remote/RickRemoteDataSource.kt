package cu.my.practice.kmp.core.domain.datasource.remote

import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.model.character.CharacterModel

interface RickRemoteDataSource {
    suspend fun getCharacters(page: Int): ResultValue<CharacterModel>

}