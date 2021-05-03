package com.fretron.usermanager.resource

import com.fretron.usermanager.service.Service
import com.fretron.usermanager.util.UserMapper
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/user/v1")
class UserResource @Inject constructor(private val service: Service) {

    @POST
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    fun addUser(request: String):Response{
        val user= UserMapper().mapper(request)
        val createdUser = this.service.createUser(user)
        return Response.ok(createdUser.toString()).build()
    }
    @GET
    @Path("user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUserById(@PathParam("userId") userId: String):Response{
        val user = service.getUserById(userId) ?: throw Exception("User not found")
        return Response.ok(user.toString()).build()

    }
    @PUT
    @Path("user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun setUserById(@PathParam("userId")  userId: String,    request: String): Response {
        val user =UserMapper().mapper(request)
        val updatedUser =service.updateUserById(userId ,user)

        return Response.ok(updatedUser.toString()).build()
    }
    @DELETE
    @Path("user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteUserById(@PathParam("userId") userId: String):Response{
        val deletedUser = service.deleteUserById(userId)
        return Response.ok(deletedUser.toString()).build()
    }

}