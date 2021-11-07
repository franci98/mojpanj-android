package si.kflabs.mojpanj.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.inject.Inject

@JsonClass(generateAdapter = true)
data class OutbreakDto (
    @Json(name = "id") val id: Int,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "apiary") val apiary: ApiaryDto,
)