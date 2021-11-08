package si.kflabs.mojpanj.data.domain.model

import java.util.*

data class Post(
    val id: Int,
    val title: String,
    val shortDescription: String,
    val content: String,
    val createdAt: Date,
) {

}