package com.example.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import java.util.UUID

@Serializable
data class Restaurant(
    @BsonId
    val id: Id<Restaurant>? = null,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val email: String,
    val admins: List<Admins>,
    val lunchMenu: List<LunchMenu>? = null,
    val dinnerMenu: List<DinnerMenu>? = null,
    val brunchMenu: List<BrunchMenu>? = null,
)

@Serializable
data class Admins(
    val id: String
)

@Serializable
data class LunchMenu(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Double,
    val description: String,
    val allergens: List<String>,
    val image: String,
)

@Serializable
data class DinnerMenu(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Double,
    val description: String,
    val allergens: List<String>,
    val image: String,
)

@Serializable
data class BrunchMenu(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Double,
    val description: String,
    val allergens: List<String>,
    val image: String,
)