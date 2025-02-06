package cu.my.practice.kmp.core.domain.data

import androidx.paging.PagingData
import cu.my.practice.kmp.core.common.Coroutine
import cu.my.practice.kmp.core.domain.repository.CharacterRepository
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import cu.my.practice.kmp.core.network.filter.CharacterPagingUsesCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class CharacterRepositoryImplement(
    private val characterPagingUsesCase: CharacterPagingUsesCase,
    private val ioDispatcher: Coroutine
) : CharacterRepository {

    override fun getCharacters(): Flow<PagingData<CharacterDataModel>> =
        characterPagingUsesCase().flowOn(ioDispatcher.ioDispatcher)

}