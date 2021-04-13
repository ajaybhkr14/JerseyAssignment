package com.fretron.usermanager.repository

import com.fretron.usermanager.model.User
import com.fretron.usermanager.util.Mapper
import com.mongodb.BasicDBObject
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.util.JSON
import org.bson.Document
import org.bson.conversions.Bson

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

    fun addUser(user: User): Boolean{
        createConnection()
        val collection =mongoDatabase?.getCollection("user")
        val document =Document.parse(user.toString())
        collection?.insertOne(document)
        closeConnection()
        return true
    }

    fun getUserById(id: String): User? {
        createConnection()
        val collection =mongoDatabase?.getCollection("user")
        var user :User? =null
        val query = BasicDBObject()
        query["id"]=id
        collection!!.find(query).iterator().use{
            point ->while (point.hasNext()){
            val document =point.next()
            document.remove("_id")
            val json =JSON.serialize(document)
            println(json.toString())
            user = Mapper().mapper(json.toString())
            }
        }
        closeConnection()
        return user
    }

    fun updateUserById(id: String,user: User): Boolean {
        println("asxaskk")
        createConnection()
        val collection =mongoDatabase?.getCollection("user")
        val query = BasicDBObject()
        query["_id"]=id
        val document = Document.parse(user.toString())
        val update = Document("\$set", document)
        val mongoCollection=collection?.findOneAndUpdate(query,update)
        return mongoCollection!=null
    }

    fun deleteUserById(id: String): Boolean {
        createConnection()
        val collection = mongoDatabase?.getCollection("user")
        val mongoCollection=collection?.deleteOne(Filters.eq("id",id))
        closeConnection()
        return mongoCollection?.deletedCount =="1".toLong()
    }
}