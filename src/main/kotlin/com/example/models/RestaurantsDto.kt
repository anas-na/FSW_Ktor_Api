package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class RestaurantsDto(
    val id: String? = null,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val admins: List<Admins>
)