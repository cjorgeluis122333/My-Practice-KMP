package cu.my.practice.kmp.core.network.filter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cu.my.practice.kmp.core.domain.datasource.remote.RickRemoteDataSource
import cu.my.practice.kmp.core.domain.usecase.paging.paging.RickPagingUsesCase
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import cu.my.practice.kmp.core.network.datasource.paging.CharacterPagingSourceFactory
import kotlinx.coroutines.flow.Flow

class CharacterPagingUsesCase(
    private val characterRemoteDataSource: RickRemoteDataSource
) : RickPagingUsesCase<Flow<PagingData<CharacterDataModel>>> {

    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 15
    }

    override fun invoke(): Flow<PagingData<CharacterDataModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                CharacterPagingSourceFactory(characterRemoteDataSource)
            }).flow
    }
}