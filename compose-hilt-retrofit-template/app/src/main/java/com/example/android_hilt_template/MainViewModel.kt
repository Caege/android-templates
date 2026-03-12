package com.example.android_hilt_template

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_hilt_template.network.PostApiService


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postApi: PostApiService) : ViewModel(){

    fun getPhotos() {
        viewModelScope.launch {
            val photos = postApi.getPosts()
            Log.d("test", photos)
        }

    }

    init {
       getPhotos()
    }

}