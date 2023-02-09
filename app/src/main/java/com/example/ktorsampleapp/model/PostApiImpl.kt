package com.example.ktorsampleapp.model

import android.util.Log
import com.example.ktorexamplelab.model.Routes
import com.example.ktorexamplelab.model.add_post.PostBody
import com.example.ktorexamplelab.model.add_post.PostResponse
import com.example.ktorexamplelab.model.posts_feed.PostFeedItem
import com.example.ktorsampleapp.utils.Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 08,Feb,2023
 */
class PostApiImpl(private val client: HttpClient) : PostApi {

    override suspend fun getPosts(): Resource<List<PostFeedItem>> {
        return try {
            val response = client.get {
                url(Routes.POSTS)
            }
            Resource.Success(response.body())
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            Resource.Error("${e.message}")
        }
    }

    override suspend fun submitPost(postBody: PostBody): Resource<PostResponse> {
        return try {
            val response = client.post {
                url(Routes.POSTS)
                setBody(postBody)
            }
            Resource.Success(response.body())
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            Resource.Error("${e.message}")
        }
    }
}