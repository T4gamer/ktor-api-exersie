package com.example.ktorsampleapp.model.remote

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 04,Feb,2023
 */

interface PostsApi {

    suspend fun getPosts(): List<Post>

}