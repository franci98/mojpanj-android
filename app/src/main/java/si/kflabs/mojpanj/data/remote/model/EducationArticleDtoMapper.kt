package si.kflabs.mojpanj.data.remote.model

import si.kflabs.mojpanj.data.domain.model.EducationArticle
import si.kflabs.mojpanj.data.domain.util.DomainMapper
import javax.inject.Inject

class EducationArticleDtoMapper @Inject constructor(): DomainMapper<EducationArticleDto, EducationArticle> {
    override fun mapToDomainModel(model: EducationArticleDto): EducationArticle {
        return  EducationArticle(
            id = model.id,
            title = model.title,
            content = model.content
        )
    }

    override fun mapFromDomainModel(domainModel: EducationArticle): EducationArticleDto {
        TODO("Not yet implemented")
    }
}