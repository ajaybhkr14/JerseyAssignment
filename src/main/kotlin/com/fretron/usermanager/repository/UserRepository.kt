package com.fretron.usermanager.repository

import com.fretron.usermanager.model.User
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.bson.Document

class UserRepository {
    var mongoClient: MongoClient?=null
    var mongoDatabase: MongoDatabase?=null

    private fun createConnection(){
        mongoClient = MongoClient("127.0.0.1", 27017)

        mongoDatabase = mongoClient?.getDatabase("userDatabase")
    }
    private fun closeConnection(){
        mongoDatabase =null
        mongoClient?.close()
    }

    val userMap = mutableMapOf<String,User>()

    fun addUser(user: User): User {
        createConnection()
        val collection =mongoDatabase?.getCollection("user")
        val document =Document.parse(user.toString())
        collection?.insertOne(document)
        closeConnection()
        return user
    }

    fun getUserById(id: String): User? {
        createConnection()
        val collection =mongoDatabase?.getCollection("user")

        return userMap[id]
    }

    fun updateUserById(id: String,name: String): User? {
        val user: User = userMap[id]!!
        if (user!=null) {
            user.name = name
        }
        userMap.set(id,user)
        return userMap[id]
    }

    fun deleteUserById(id: String): User? {
        createConnection()
        val collection = mongoDatabase?.getCollection("user")
        collection?.deleteOne(Filters.eq("id",id))
        closeConnection()
        val user = userMap[id]
        userMap.remove(id)
        return user

    }
}