package com.example.ktorsampleapp.model

import com.example.ktorexamplelab.model.add_post.PostBody
import com.example.ktorexamplelab.model.add_post.PostResponse
import com.example.ktorexamplelab.model.posts_feed.PostFeedItem
import com.example.ktorsampleapp.utils.Resource

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 08,Feb,2023
 */
interface PostApi {

    suspend fun getPosts(): Resource<List<PostFeedItem>>

    suspend fun submitPost(postBody: PostBody): Resource<PostResponse>

}