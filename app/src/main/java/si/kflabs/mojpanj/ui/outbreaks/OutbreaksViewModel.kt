package si.kflabs.mojpanj.ui.outbreaks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import si.kflabs.mojpanj.data.domain.model.Outbreak
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.data.repository.ApiaryRepository
import javax.inject.Inject

@HiltViewModel
class OutbreaksViewModel @Inject constructor(
    private val apiaryRepository: ApiaryRepository
): ViewModel() {

    private val _outbreaks: MutableLiveData<Resource<List<Outbreak>>> = MutableLiveData()
    val outbreaks: LiveData<Resource<List<Outbreak>>> = _outbreaks

    init {
        viewModelScope.launch {
            _outbreaks.postValue(Resource.Loading)
            _outbreaks.postValue(apiaryRepository.getOutbreaks())
        }
    }
}