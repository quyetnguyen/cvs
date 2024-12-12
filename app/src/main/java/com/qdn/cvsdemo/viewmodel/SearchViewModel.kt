package com.qdn.cvsdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qdn.cvsdemo.data.model.FlickrImage
import com.qdn.cvsdemo.data.repository.FlickrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: FlickrRepository
) : ViewModel() {
    private val _query = MutableStateFlow("")
    private val _images = MutableStateFlow<List<FlickrImage>>(emptyList())
    private val _loading = MutableStateFlow(false)
    private val _error = MutableStateFlow<String?>(null)

    val query: StateFlow<String> = _query
    val images: StateFlow<List<FlickrImage>> = _images
    val loading: StateFlow<Boolean> = _loading
    val error: StateFlow<String?> = _error

    init {
        // Update results whenever query changes
        viewModelScope.launch {
            // debounce here to prevent sending a lot of requests for each key
            // waits an arbitrary 300ms before executing
            _query.debounce(300)
                .collect { tags ->
                    fetchImages(tags)
                }
        }
    }

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
    }

    private fun fetchImages(tags: String) {
        viewModelScope.launch {
            _loading.value = true
            val result = repository.searchImages(tags)
            _loading.value = false
            result.fold(
                onSuccess = { images -> _images.value = images },
                onFailure = { error ->
                    _error.value = "Failed to fetch images: ${error.message}"
                }
            )
        }
    }

    fun clearError() {
        _error.value = null
    }
}