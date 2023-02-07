package com.example.ktorsampleapp.model.remote

import kotlinx.serialization.Serializable

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 07,Feb,2023
 */
@Serializable
data class Post(
    val id: String,
    val title: String,
    val content: String,
    val slug: String,
    val picture: String,
    val user: String
)