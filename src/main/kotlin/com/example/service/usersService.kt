package com.example.service

import com.example.models.User
import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.litote.kmongo.id.toId

class usersService {
    private val client = KMongo.createClient()
    private val database = client.getDatabase("Resyandordersdb")
    private val UsersCollection = database.getCollection<User>()

    fun create(user: User): Id<User>? {
        UsersCollection.insertOne(user)
        return user.id
    }

    fun findAll(): List<User> =
        UsersCollection.find()
            .toList()

    fun findById(id: String): User? {
        val bsonId: Id<User> = ObjectId(id).toId()
        return UsersCollection.findOne(User::id eq bsonId)
    }

    fun updateUser(id: String, request: User): Boolean =
        findById(id)?.let { user ->
            val updatedUser = UsersCollection.replaceOne(
                user.copy(
                    firstName = request.firstName,
                    lastName = request.lastName,
                    email = request.email,
                    phoneNumber = request.phoneNumber,
                    password = request.password,
                    isRestaurantAdmin = request.isRestaurantAdmin
                )
            )
            updatedUser.modifiedCount == 1L
        } ?: false

    fun deleteUser(id: String): Boolean {
        val deleteUser = UsersCollection.deleteOneById(ObjectId(id))
        return deleteUser.deletedCount == 1L
    }
}


