package service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.usermanager.model.User
import com.fretron.usermanager.repository.UserRepository
import com.fretron.usermanager.service.Service
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock
import testData.TestData

class userServiceTest {
    private val mapper = ObjectMapper()
    private val userRepository:UserRepository=mock(UserRepository::class.java)
    private var userService= Service(userRepository)
    private lateinit var id:String

    @Test
    fun createUser(){
        val request =TestData.createUser()
        val user =  mapper.readValue(request,User::class.java)
        whenever(userService.createUser(user)).thenReturn(true)
        val createdUser  =  userService.createUser(user)
        println(createdUser.toString())
        assertNotNull(createdUser)
        assertNotNull(userService.getUserById(id)?.name)
    }
    @Test
    fun getUser(){
        createUser()
        val request = TestData.getUser().id
        assert(request!=null)
        assertNotEquals("",request)
    }
    @Test
    fun updateUser(){
        createUser()
        val request = TestData.updateUser()
        val updateUser = mapper.readValue(request,User::class.java)
        whenever(userService.createUser(updateUser)).thenReturn(true)
        val updated = userService.updateUserById(id,updateUser)
        assert(userService.getUserById(id)?.name!= null)
        assert(updated)
    }
    @Test
    fun deleteUser(){
        createUser()
        val request =TestData.getUser()
        whenever(userService.deleteUserById(request.id.toString())).thenReturn(true)
        val deleted = userService.deleteUserById(id)
        assert(deleted)
    }


}