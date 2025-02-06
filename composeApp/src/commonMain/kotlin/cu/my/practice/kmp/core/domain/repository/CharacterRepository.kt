package cu.my.practice.kmp.core.domain.repository

import androidx.paging.PagingData
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(): Flow<PagingData<CharacterDataModel>>
}