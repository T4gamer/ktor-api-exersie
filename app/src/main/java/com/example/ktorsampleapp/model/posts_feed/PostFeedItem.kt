package com.example.ktorexamplelab.model.posts_feed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostFeedItem(
    @SerialName("content")
    val content: String?,
    @SerialName("id")
    val id: String,
    @SerialName("picture")
    val picture: String?,
    @SerialName("slug")
    val slug: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("user")
    val user: String?
)