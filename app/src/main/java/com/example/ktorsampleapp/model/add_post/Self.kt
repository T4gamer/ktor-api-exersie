package com.example.ktorexamplelab.model.add_post


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Self(
    @SerialName("href")
    val href: String?
)