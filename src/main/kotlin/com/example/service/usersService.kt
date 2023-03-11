package com.example.service

import com.example.models.User
import org.litote.kmongo.Id
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

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

}


