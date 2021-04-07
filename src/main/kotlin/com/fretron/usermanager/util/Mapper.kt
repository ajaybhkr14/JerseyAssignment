package com.fretron.usermanager.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fretron.usermanager.model.User

class Mapper {
    fun mapper(json :String) : User {
        val mapp = jacksonObjectMapper()
        val user : User = mapp.readValue(json ,User::class.java)
        return user
    }
}