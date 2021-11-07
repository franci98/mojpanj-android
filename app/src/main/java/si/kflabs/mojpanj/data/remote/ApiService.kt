package si.kflabs.mojpanj.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import si.kflabs.mojpanj.data.domain.model.EducationCategory
import si.kflabs.mojpanj.data.remote.model.EducationArticleDto
import si.kflabs.mojpanj.data.remote.model.EducationCategoryDto
import si.kflabs.mojpanj.data.remote.model.OutbreakDto
import si.kflabs.mojpanj.data.remote.model.PostDto

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET("outbreaks")
    suspend fun getOutbreaks(): List<OutbreakDto>

    @GET("education-categories")
    suspend fun getEducationCategories(): List<EducationCategoryDto>

    @GET("education-categories/{id}/education-articles")
    suspend fun getEducationArticles(
        @Path("id") id: Int,
    ): List<EducationArticleDto>

}