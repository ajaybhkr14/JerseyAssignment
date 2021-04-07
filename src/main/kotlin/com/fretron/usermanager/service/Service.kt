package com.fretron.usermanager.service

import com.fretron.usermanager.model.User
import com.fretron.usermanager.repository.UserRepository
import java.util.*

class Service(private val repository: UserRepository) {

    fun createUser(user: User): User {
        if (user.name!!.isBlank()) throw Exception("name can't be blank")
        user.id = UUID.randomUUID().toString()
        val mapId = user.id.toString()
        return repository.addUser(mapId,user)
    }

    fun getUserById(userId: String): User? {
        return repository.getUserById(userId)
    }
    fun updateUserById(userId: String ,name :String) :User?{
        if(getUserById(userId)==null)throw Exception("No User Found By id - $userId")
        else{ return repository.updateUserById(userId ,name )}
    }
    fun deleteUserById(userId: String) :User?{
        if(getUserById(userId)==null)throw Exception("No User Found By id - $userId")
        else{
        return repository.deleteUserById(userId)
    }
    }

}
