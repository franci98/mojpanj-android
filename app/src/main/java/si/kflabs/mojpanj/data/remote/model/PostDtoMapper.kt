package si.kflabs.mojpanj.data.remote.model

import android.icu.text.DateFormat
import android.icu.text.SimpleDateFormat
import si.kflabs.mojpanj.data.domain.model.Post
import si.kflabs.mojpanj.data.domain.util.DomainMapper
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class PostDtoMapper @Inject constructor(

) : DomainMapper<PostDto, Post> {
    override fun mapToDomainModel(model: PostDto): Post {
        return Post(
            id = model.id,
            title = model.title,
            shortDescription = model.shortDescription,
            content = model.content,
            createdAt = Calendar.getInstance(),
        )
    }

    override fun mapFromDomainModel(domainModel: Post): PostDto {
        TODO("Not yet implemented")
    }
}