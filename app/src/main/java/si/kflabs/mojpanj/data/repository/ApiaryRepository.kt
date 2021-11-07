package si.kflabs.mojpanj.data.repository

import si.kflabs.mojpanj.data.domain.model.Outbreak
import si.kflabs.mojpanj.data.remote.ApiService
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.data.remote.model.OutbreakDto
import si.kflabs.mojpanj.data.remote.model.OutbreakDtoMapper
import javax.inject.Inject

class ApiaryRepository @Inject constructor(
    private val apiService: ApiService,
    private val outbreakDtoMapper: OutbreakDtoMapper
): BaseRepository() {

    suspend fun getOutbreaks(): Resource<List<Outbreak>> {
        return safeApiCall {
            apiService.getOutbreaks().map { outbreakDtoMapper.mapToDomainModel(it)  }
        }
    }

}