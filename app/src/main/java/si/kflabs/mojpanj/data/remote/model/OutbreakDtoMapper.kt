package si.kflabs.mojpanj.data.remote.model

import si.kflabs.mojpanj.data.domain.model.Outbreak
import si.kflabs.mojpanj.data.domain.util.DomainMapper
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class OutbreakDtoMapper @Inject constructor(
    private val apiaryDtoMapper: ApiaryDtoMapper
): DomainMapper<OutbreakDto, Outbreak> {
    override fun mapToDomainModel(model: OutbreakDto): Outbreak {
        val originalFormat = SimpleDateFormat("yyyyMMdd")
        return Outbreak(
            id = model.id,
            apiary = apiaryDtoMapper.mapToDomainModel(model = model.apiary),
            createdAt = originalFormat.parse(model.createdAt) ?: Date()
        )
    }

    override fun mapFromDomainModel(domainModel: Outbreak): OutbreakDto {
        TODO("Not yet implemented")
    }
}