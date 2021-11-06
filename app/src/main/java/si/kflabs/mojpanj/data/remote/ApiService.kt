package si.kflabs.mojpanj.data.remote

import retrofit2.http.GET
import si.kflabs.mojpanj.data.remote.model.PostDto

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>

}