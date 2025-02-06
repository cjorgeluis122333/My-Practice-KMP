package cu.my.practice.kmp.core.network.datasource.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cu.my.practice.kmp.core.domain.datasource.remote.RickRemoteDataSource
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.model.character.CharacterDataModel

class CharacterPagingSourceFactory(private val rickRemoteDataSource: RickRemoteDataSource) :
    PagingSource<Int, CharacterDataModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterDataModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDataModel> {
        val actualPage: Int = params.key ?: 1

        return when (val request = rickRemoteDataSource.getCharacters(actualPage)) {
            is ResultValue.Error -> LoadResult.Error(request.exception)

            is ResultValue.Success -> LoadResult.Page(
                data = request.data.results,
                nextKey = if (request.data.info.next != null) actualPage + 1 else null,
                prevKey = if (actualPage > 0) actualPage - 1 else null
            )
        }
    }



    }