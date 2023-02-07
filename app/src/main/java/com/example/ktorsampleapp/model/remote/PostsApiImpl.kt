package com.example.ktorsampleapp.model.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 04,Feb,2023
 */
class PostsApiImpl(
    private val client: HttpClient
): PostsApi {
    override suspend fun getPosts(): List<Post> {
        return client.get {
            url(Routes.POSTS)
        }.body()
    }
}