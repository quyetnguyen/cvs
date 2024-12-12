package com.qdn.cvsdemo.viewmodel

import androidx.lifecycle.ViewModel
import com.qdn.cvsdemo.data.model.FlickrImage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {
    var selectedImage: FlickrImage? = null
}