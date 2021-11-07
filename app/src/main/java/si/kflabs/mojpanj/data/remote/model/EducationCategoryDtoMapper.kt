package si.kflabs.mojpanj.data.remote.model

import si.kflabs.mojpanj.data.domain.model.EducationCategory
import si.kflabs.mojpanj.data.domain.util.DomainMapper
import javax.inject.Inject

class EducationCategoryDtoMapper @Inject constructor(): DomainMapper<EducationCategoryDto, EducationCategory> {
    override fun mapToDomainModel(model: EducationCategoryDto): EducationCategory {
        return EducationCategory(
            id = model.id,
            title = model.title,
        )
    }

    override fun mapFromDomainModel(domainModel: EducationCategory): EducationCategoryDto {
        TODO("Not yet implemented")
    }
}