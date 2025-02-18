package cu.my.practice.kmp.feature.rick_paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cu.my.practice.kmp.core.domain.usecase.character.GetCharactersUsesCase
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import cu.my.practice.kmp.feature.rick_paging.state.RickUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow

class RickMortyViewModel(
    private val charactersUseCase: GetCharactersUsesCase
) : ViewModel() {
    private val _rickUiState = MutableStateFlow(RickUiState())
    private val rickUiState = _rickUiState.asStateFlow()

    var getCharacters: Flow<PagingData<CharacterDataModel>> = emptyFlow()


    init {
        getCharacters()
    }

    private fun getCharacters() {
        getCharacters = charactersUseCase().cachedIn(viewModelScope)
    }


    /*

//Actions
private fun getReserves() = viewModelScope.launch {
reserves = fetchPlanService(filterData.values).cachedIn(viewModelScope)
}

    * */

}