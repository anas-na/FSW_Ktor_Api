package com.example.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Restaurant(
    @BsonId
    val id: Id<Restaurant>? = null,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
)
