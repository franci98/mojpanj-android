package si.kflabs.mojpanj.data.domain.model

import java.util.*

data class Outbreak(
    val id: Int,
    val apiary: Apiary,
    val createdAt: Date
)