package cu.my.practice.kmp.core.domain.usecase.character

import androidx.paging.PagingData
import cu.my.practice.kmp.core.domain.repository.CharacterRepository
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import kotlinx.coroutines.flow.Flow

class GetCharactersUsesCase(
    private val characterRepository: CharacterRepository
) {

    operator fun invoke(): Flow<PagingData<CharacterDataModel>> =
        characterRepository.getCharacters()
}