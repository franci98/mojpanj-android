package si.kflabs.mojpanj.data.repository

import si.kflabs.mojpanj.data.domain.model.Post
import si.kflabs.mojpanj.data.remote.ApiService
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.data.remote.model.PostDto
import si.kflabs.mojpanj.data.remote.model.PostDtoMapper
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService,
    private val postDtoMapper: PostDtoMapper
): BaseRepository() {

    suspend fun getPosts(): Resource<List<Post>> {
        return safeApiCall { apiService.getPosts().map { postDto -> postDtoMapper.mapToDomainModel(postDto) } }
    }
}