package si.kflabs.mojpanj.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import si.kflabs.mojpanj.data.domain.model.Post
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.data.repository.PostRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {
    private val _posts: MutableLiveData<Resource<List<Post>>> = MutableLiveData()
    val posts: LiveData<Resource<List<Post>>> = _posts

    init {
        viewModelScope.launch {
            _posts.postValue(Resource.Loading)
            _posts.postValue(postRepository.getPosts())
        }
    }
}