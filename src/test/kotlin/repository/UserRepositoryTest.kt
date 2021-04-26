package repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.usermanager.model.User
import com.fretron.usermanager.repository.UserRepository
import org.junit.Assert.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

import testData.TestData

class UserRepositoryTest {
    private lateinit var userRepository: UserRepository
    private val objectMapper = ObjectMapper()
    private val uuid :String=""

    @BeforeEach
    fun config(){
    userRepository = mock(UserRepository::class.java)

    }
    @Test
    fun createUser(){
        println("hjh")
        val request = TestData.createUser()
        val user = objectMapper.readValue(request,User::class.java)
        val userCreated = userRepository.addUser(user)
        println("user = $userCreated")
        println(userCreated.toString())
        assertNotNull(userCreated)
    }

    @Test
    fun getUser(){
        val user =TestData.getUser()
        val userCreated = userRepository.addUser(user)
        println("user = $userCreated")
        val userDb =userRepository.getUserById(uuid)
        println("Db user =$userDb")
        assertNotNull(userCreated)
    }
    @Test
    fun updateUser(){
        val user=TestData.getUser()
        val createUser =userRepository.addUser(user)
        println("update user")
        println("user = $createUser")
        val request = TestData.updateUser()
        val updateUser = objectMapper.readValue(request,User::class.java)
        val userUpdated =userRepository.updateUserById(uuid,updateUser)
        println("updated user in db = $userUpdated")
        assertNotNull(userUpdated)
    }
    @Test
    fun deleteUser(){
        val user =TestData.getUser()
        val createUser =userRepository.addUser(user)
        println("user = $createUser")
        val userDeleted =userRepository.deleteUserById(uuid)
        println("Deleted Vehicle from DB -> $userDeleted")
        assertNotNull(userDeleted)
    }
}