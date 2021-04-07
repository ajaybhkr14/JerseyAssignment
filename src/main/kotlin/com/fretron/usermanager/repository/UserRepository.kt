package com.fretron.usermanager.repository

import com.fretron.usermanager.model.User

class UserRepository {

    val userMap = mutableMapOf<String,User>();

    fun addUser(id: String,user: User): User {
        userMap[id] = user
        return user
    }

    fun getUserById(id: String): User? {
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

        val user = userMap[id]
        userMap.remove(id)
        return user

    }
}