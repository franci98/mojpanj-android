package si.kflabs.mojpanj.data.remote.model

import si.kflabs.mojpanj.data.domain.model.Apiary
import si.kflabs.mojpanj.data.domain.util.DomainMapper
import javax.inject.Inject

class ApiaryDtoMapper @Inject constructor(
): DomainMapper<ApiaryDto, Apiary> {
    override fun mapToDomainModel(model: ApiaryDto): Apiary {
        return Apiary(
            id = model.id,
            lat = model.lat,
            lon = model.lon,
            kmgMid = model.kmgMid,
        )
    }

    override fun mapFromDomainModel(domainModel: Apiary): ApiaryDto {
        TODO("Not yet implemented")
    }
}