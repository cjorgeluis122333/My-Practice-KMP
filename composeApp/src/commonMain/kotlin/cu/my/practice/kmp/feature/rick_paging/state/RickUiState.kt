package cu.my.practice.kmp.feature.rick_paging.state

import cu.my.practice.kmp.core.model.character.CharacterDataModel

class RickUiState(
    val loading: Boolean = false,
    val data: List<CharacterDataModel> = emptyList(),
    val error: String? = null,
    val refresh: Boolean = true
)