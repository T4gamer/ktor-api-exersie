package com.example.ktorexamplelab.model.add_post


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostBody(
    @SerialName("content")
    val content: String,
    @SerialName("picture")
    val picture: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("title")
    val title: String,
    @SerialName("user")
    val user: Int
)