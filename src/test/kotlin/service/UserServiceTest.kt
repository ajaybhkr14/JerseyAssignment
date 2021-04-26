package service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.usermanager.model.User
import com.fretron.usermanager.repository.UserRepository
import com.fretron.usermanager.service.Service
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock
import testData.TestData

class userServiceTest {
    private val mapper = ObjectMapper()
    private val userRepository:UserRepository=mock(UserRepository::class.java)
    private var userService= Service(userRepository)
    private lateinit var uuid:String

    @Test
    fun createUser(){
        val request =TestData.createUser()
        val user =  mapper.readValue(request,User::class.java)
        val createdUser  =  userService.createUser(user)
        println(createdUser.toString())
        assertNotNull(createdUser)
        assertNotNull(userService.getUserById(uuid)?.name)
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
        val updated = userService.updateUserById(uuid,updateUser)
        assert(userService.getUserById(uuid)?.name!= null)

    }
    @Test
    fun deleteUser(){
        createUser()
        val request =TestData.getUser()
        val deleted = userService.deleteUserById(uuid)
        assert(deleted)
    }


}