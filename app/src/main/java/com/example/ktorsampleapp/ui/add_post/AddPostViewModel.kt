package com.example.ktorexamplelab.ui.add_post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorexamplelab.model.add_post.PostBody
import com.example.ktorexamplelab.model.add_post.PostResponse
import com.example.ktorsampleapp.model.PostApiImpl
import com.example.ktorsampleapp.utils.Provider
import com.example.ktorsampleapp.utils.Resource
import kotlinx.coroutines.launch

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 09,Feb,2023
 */
class AddPostViewModel : ViewModel() {

    private val _addPostResponse = MutableLiveData<Resource<PostResponse>>()
    val addPostResponse: LiveData<Resource<PostResponse>> get() = _addPostResponse

    private val postApi = PostApiImpl(Provider.client)

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