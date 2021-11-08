package si.kflabs.mojpanj.data.remote.model

import si.kflabs.mojpanj.data.domain.model.Post
import si.kflabs.mojpanj.data.domain.util.DomainMapper
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class PostDtoMapper @Inject constructor(

) : DomainMapper<PostDto, Post> {
    override fun mapToDomainModel(model: PostDto): Post {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.ENGLISH)
        return Post(
            id = model.id,
            title = model.title,
            shortDescription = model.shortDescription,
            content = model.content,
            createdAt = sdf.parse(model.createdAt),
        )
    }

    override fun mapFromDomainModel(domainModel: Post): PostDto {
        TODO("Not yet implemented")
    }
}