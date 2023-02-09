package com.example.ktorsampleapp.ui.posts_feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorexamplelab.model.posts_feed.PostFeedItem
import com.example.ktorsampleapp.model.PostApiImpl
import com.example.ktorsampleapp.utils.Provider
import com.example.ktorsampleapp.utils.Resource
import kotlinx.coroutines.launch

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 08,Feb,2023
 */
class PostsFeedViewModel : ViewModel() {

    private val postApi = PostApiImpl(Provider.client)
    private val _posts: MutableLiveData<Resource<List<PostFeedItem>>> =
        MutableLiveData(Resource.Loading())
    val posts: LiveData<Resource<List<PostFeedItem>>> get() = _posts

    init {
        getPosts()

    }

    fun getPosts() {
        viewModelScope.launch {
            _posts.value = Resource.Loading()
            _posts.value = postApi.getPosts()
        }
    }

}