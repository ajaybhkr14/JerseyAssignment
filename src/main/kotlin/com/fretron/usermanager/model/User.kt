package com.fretron.usermanager.model

import org.json.JSONObject

data class User(var id: String?,var age: Int?,var name: String? ) {
    constructor() : this(id = null , age = null ,name = null)
    override fun toString(): String {
        val json = JSONObject().put("id",this.id)
            .put("age",this.age).put("name",this.name)
        return json.toString()
    }
}