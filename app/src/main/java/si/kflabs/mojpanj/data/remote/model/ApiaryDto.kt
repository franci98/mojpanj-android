package si.kflabs.mojpanj.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiaryDto(
    @Json(name = "id") val id: Int,
    @Json(name = "lat") val lat: Double,
    @Json(name = "lon") val lon: Double,
    @Json(name = "kmg_mid") val kmgMid: String,
    @Json(name = "created_at") val createdAt: String,
)