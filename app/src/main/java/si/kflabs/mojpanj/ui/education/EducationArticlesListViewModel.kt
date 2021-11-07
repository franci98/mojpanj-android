package si.kflabs.mojpanj.ui.education

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import si.kflabs.mojpanj.data.domain.model.EducationArticle
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.data.repository.EducationRepository
import javax.inject.Inject

@HiltViewModel
class EducationArticlesListViewModel @Inject constructor(
    private val educationRepository: EducationRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private var educationCategoryId: Int = savedStateHandle.get<Int>("educationCategoryId") ?: 1

    private val _educationArticles: MutableLiveData<Resource<List<EducationArticle>>> = MutableLiveData()
    val educationArticles: LiveData<Resource<List<EducationArticle>>> = _educationArticles

    init {
        viewModelScope.launch {
            _educationArticles.postValue(Resource.Loading)
            _educationArticles.postValue(educationRepository.getArticles(educationCategoryId = educationCategoryId))
        }
    }

}