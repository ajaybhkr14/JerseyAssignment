package resource

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.usermanager.resource.Resource
import com.fretron.usermanager.service.Service
import junit.framework.Assert.assertTrue
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.test.JerseyTest
import org.json.JSONObject
import org.junit.Test
import org.mockito.Mockito.mock
import testData.TestData
import javax.ws.rs.client.Entity
import javax.ws.rs.core.Application
import javax.ws.rs.core.MediaType

class UserResourceTest : JerseyTest() {
    private val baseUrl = "vehicle/v1"
    private var id = ""
    private val userService: Service = mock(Service::class.java)
    private val mapper = ObjectMapper()

    override fun configure(): Application {
        return ResourceConfig().register(Resource(userService)).application
    }

    @Test
    fun status_200_createUSer() {
        val request = TestData.createUser()
        val response = target("$baseUrl/user").request().post(Entity.entity(request, MediaType.APPLICATION_JSON))
        println("Response :${response.status}")
        assertTrue("Response Status : ", response.status == 200)
        val responseJson = JSONObject(response.readEntity(String::class.java))
        id = responseJson.get("id").toString()
        assert(responseJson.get("id") != null)
        println("Response Json -> $responseJson")
    }

    @Test
    fun status_200_getUser() {
        val testUser = TestData.getUser()
        // whenever(Service.getUser(any())).thenReturn(testUser)
        val response = target("$baseUrl/user/$id").request().get()
        println(response.status)
        assertTrue("Response Status : ", response.status == 200)
        val responseJson = JSONObject(response.readEntity(String::class.java))
        println("response  id : ${responseJson.get("id")}")
    }

    @Test
    fun status_200_updateUSer() {
        val updatedRequest = TestData.updateUser()
        val response = target("$baseUrl/user").request().put(Entity.entity(updatedRequest, MediaType.APPLICATION_JSON))
        println(response.status)
        assertTrue("Response Status : ", response.status == 200)
    }

    @Test
    fun status_200_delete() {
        val response = target("$baseUrl/user/$id").request().delete()
        println(response.status)
        assertTrue("Response Status : ", response.status == 200)
        val responseJson = JSONObject(response.readEntity(String::class.java))
        println("response  id : ${responseJson.get("id")}")
    }
}