package si.kflabs.mojpanj.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EducationCategoryDto(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
) {
}