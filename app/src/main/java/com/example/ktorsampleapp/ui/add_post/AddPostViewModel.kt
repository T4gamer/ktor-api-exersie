package com.example.ktorexamplelab.ui.add_post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorexamplelab.model.add_post.PostBody
import com.example.ktorexamplelab.model.add_post.PostResponse
import com.example.ktorsampleapp.model.PostApi
import com.example.ktorsampleapp.model.PostApiImpl
import com.example.ktorsampleapp.utils.Provider
import com.example.ktorsampleapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 09,Feb,2023
 */
@HiltViewModel
class AddPostViewModel @Inject constructor(val postApi: PostApi): ViewModel() {

    private val _addPostResponse = MutableLiveData<Resource<PostResponse>>()
    val addPostResponse: LiveData<Resource<PostResponse>> get() = _addPostResponse
    fun submitPost(postBody: PostBody) {
        if (postBody.title.isBlank() || postBody.content.isBlank()) {
            _addPostResponse.value = Resource.Error("Title and Content can't be empty!")
        } else {
            viewModelScope.launch {
                _addPostResponse.value = Resource.Loading()
                _addPostResponse.value = postApi.submitPost(postBody)
            }
        }
    }
}