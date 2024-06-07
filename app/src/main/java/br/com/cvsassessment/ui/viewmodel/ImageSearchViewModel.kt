package br.com.cvsassessment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cvsassessment.data.model.FlickerItem
import br.com.cvsassessment.di.NetworkModule
import br.com.cvsassessment.service.FlickerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImageSearchViewModel() : ViewModel() {
    private val repository = FlickerRepository(NetworkModule.flickerApiService)
    private val _images = MutableStateFlow<List<FlickerItem>>(emptyList())
    val images: StateFlow<List<FlickerItem>> = _images

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _selectedImage = MutableStateFlow<FlickerItem?>(null)
    val selectedImage: StateFlow<FlickerItem?> = _selectedImage

    private val _searchBarText = MutableStateFlow("")
    val searchBarText: StateFlow<String> = _searchBarText

    fun searchImages(query: String) {
        _searchBarText.value = query
        viewModelScope.launch {
            _isLoading.value = true
            val response = repository.searchImages(query)
            _images.value = response?.items ?: emptyList()
            _isLoading.value = false
        }
    }

    fun selectImage(image: FlickerItem) {
        _selectedImage.value = image
    }

    fun deselectImage() {
        _selectedImage.value = null
    }
}
