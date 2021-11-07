package si.kflabs.mojpanj.ui.education

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import si.kflabs.mojpanj.data.domain.model.EducationCategory
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.data.repository.EducationRepository
import javax.inject.Inject

@HiltViewModel
class EducationCategoriesListViewModel @Inject constructor(
    private val educationRepository: EducationRepository
) : ViewModel() {
    private val _educationCategories: MutableLiveData<Resource<List<EducationCategory>>> = MutableLiveData()
    val educationCategories: LiveData<Resource<List<EducationCategory>>> = _educationCategories

    init {
        viewModelScope.launch {
            _educationCategories.postValue(Resource.Loading)
            _educationCategories.postValue(educationRepository.getCategories())
        }
    }

}