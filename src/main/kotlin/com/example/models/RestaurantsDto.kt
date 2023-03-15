package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class RestaurantsDto(
    val id: String? = null,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val email: String,
    val admins: List<Admins>,
    val lunchMenu: List<LunchMenu>? = null,
    val dinnerMenu: List<DinnerMenu>? = null,
    val brunchMenu: List<BrunchMenu>? = null,
)