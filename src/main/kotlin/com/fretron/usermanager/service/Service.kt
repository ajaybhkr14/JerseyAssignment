package com.fretron.usermanager.service

import com.fretron.usermanager.model.User
import com.fretron.usermanager.repository.UserRepository
import java.util.*
import javax.inject.Inject

class Service @Inject constructor(private val repository: UserRepository) {

    fun createUser(user: User): Boolean {
        if (user.name.isNullOrBlank()) throw Exception("required field user name can't be  null or blank")
        user.id = UUID.randomUUID().toString()
        return repository.addUser(user)
    }

    fun getUserById(userId: String): User? {
        return repository.getUserById(userId)
    }

    fun updateUserById(userId: String,user: User): Boolean {
        if (getUserById(userId)==null) throw Exception("No User Found By id - $userId")
        else {
            println("service")
            return repository.updateUserById(userId,user)
        }
    }

    fun deleteUserById(userId: String): Boolean {
        if (getUserById(userId)==null) throw Exception("No User Found By id - $userId")
        else {
            return repository.deleteUserById(userId)
        }
    }

}
