package com.example.ktorsampleapp.ui.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorsampleapp.model.remote.Post
import com.example.ktorsampleapp.model.remote.PostsApi
import com.example.ktorsampleapp.model.remote.PostsApiImpl
import com.example.ktorsampleapp.utils.Provider
import kotlinx.coroutines.launch

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 07,Feb,2023
 */
class PostViewModel: ViewModel() {

    private var postsApi: PostsApi = PostsApiImpl(Provider.client)
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData(emptyList())
    val posts: LiveData<List<Post>> get() = _posts

    init {
        loadPostsFromApi()
    }

    fun loadPostsFromApi(){
        viewModelScope.launch {
            _posts.value = postsApi.getPosts()
        }
    }


}