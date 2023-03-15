package com.example.service

import com.example.models.Restaurant
import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.litote.kmongo.id.toId

class RestaurantsService {
    private val client = KMongo.createClient()
    private val database = client.getDatabase("Resyandordersdb")
    private val RestaurantsCollection = database.getCollection<Restaurant>()

    fun findAll(): List<Restaurant> =
        RestaurantsCollection.find()
            .toList()

    fun findById(id: String): Restaurant? {
        val bsonId: Id<Restaurant> = ObjectId(id).toId()
        return RestaurantsCollection.findOne(Restaurant::id eq bsonId)
    }

    fun create(restaurant: Restaurant): Id<Restaurant>? {
        RestaurantsCollection.insertOne(restaurant)
        return restaurant.id
    }

    fun updateRestaurant(id: String, request: Restaurant): Boolean =
        findById(id)?.let { restaurant ->
            val updatedRestaurant = RestaurantsCollection.replaceOne(
                restaurant.copy(
                    name = request.name,
                    address = request.address,
                    phoneNumber = request.phoneNumber,
                    email = request.email,
                    lunchMenu = request.lunchMenu,
                    dinnerMenu = request.dinnerMenu,
                    brunchMenu = request.brunchMenu,
                )
            )
            updatedRestaurant.modifiedCount == 1L
        } ?: false

    fun deleteRestaurant(id: String): Boolean {
        val deleteRestaurant = RestaurantsCollection.deleteOneById(ObjectId(id))
        return deleteRestaurant.deletedCount == 1L
    }
}