package si.kflabs.mojpanj.data.repository

import si.kflabs.mojpanj.data.domain.model.EducationArticle
import si.kflabs.mojpanj.data.domain.model.EducationCategory
import si.kflabs.mojpanj.data.remote.ApiService
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.data.remote.model.EducationArticleDtoMapper
import si.kflabs.mojpanj.data.remote.model.EducationCategoryDtoMapper
import javax.inject.Inject

class EducationRepository @Inject constructor(
    private val apiService: ApiService,
    private val educationCategoryDtoMapper: EducationCategoryDtoMapper,
    private val educationArticleDtoMapper: EducationArticleDtoMapper,
) : BaseRepository() {

    suspend fun getCategories(): Resource<List<EducationCategory>> {
        return safeApiCall { apiService.getEducationCategories().map { educationCategoryDtoMapper.mapToDomainModel(it) } }
    }

    suspend fun getArticles(educationCategoryId: Int): Resource<List<EducationArticle>> {
        return safeApiCall { apiService.getEducationArticles(id = educationCategoryId).map { educationArticleDtoMapper.mapToDomainModel(it) } }
    }
}