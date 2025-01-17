package com.example.api_project


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("delete")
    val delete: Delete,
    @SerialName("modify")
    val modify: Modify,
    @SerialName("self")
    val self: Self
)