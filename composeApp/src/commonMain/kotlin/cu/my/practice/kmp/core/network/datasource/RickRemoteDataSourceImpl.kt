package cu.my.practice.kmp.core.network.datasource

import cu.my.practice.kmp.core.domain.datasource.remote.RickRemoteDataSource
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.model.character.CharacterModel
import cu.my.practice.kmp.core.network.mapper.toModel
import cu.my.practice.kmp.core.network.service.network.RickService

class RickRemoteDataSourceImpl(
    private val rickService: RickService
) : RemoteDatasourceAbstraction(), RickRemoteDataSource {

    override suspend fun getCharacters(page: Int): ResultValue<CharacterModel> = safeApiCall {
        rickService.getCharacters(page).toModel()
    }

}