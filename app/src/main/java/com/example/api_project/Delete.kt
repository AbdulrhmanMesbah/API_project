package com.example.api_project


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Delete(
    @SerialName("href")
    val href: String
)