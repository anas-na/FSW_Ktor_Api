package com.example.service

import com.example.models.User
import org.litote.kmongo.Id
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

class usersService {
    private val client = KMongo.createClient()
    private val database = client.getDatabase("Resyandordersdb")
    private val personCollection = database.getCollection<User>()

    fun create(user: User): Id<User>? {
        personCollection.insertOne(user)
        return user.id
    }

    fun findAll(): List<User> =
        personCollection.find()
            .toList()
}


