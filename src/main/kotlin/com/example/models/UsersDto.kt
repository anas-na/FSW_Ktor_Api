package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class UsersDto(
    val id: String? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val isRestaurantAdmin: Boolean = false,
)

