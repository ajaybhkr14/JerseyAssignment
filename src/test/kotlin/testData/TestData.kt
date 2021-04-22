package testData

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.usermanager.model.User

object TestData {
    private var objectMapper = ObjectMapper()
    fun createUser():String{
        return "{\n" +
                "    \"name\":\"COVID19\",\n" +
                "    \"id\":\"19\",\n" +
                "    \"age\":2\n" +
                "}"
    }
    fun getUser(): User{
        return objectMapper.readValue(createUser(),User::class.java)
    }
    fun updateUser() :String{
        return "{\n" +
                "    \"name\":\"COVID19GONE\",\n" +
                "    \"id\":\"19\",\n" +
                "    \"age\":2\n" +
                "}"
    }

}