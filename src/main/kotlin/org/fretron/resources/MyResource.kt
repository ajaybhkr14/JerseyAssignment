package org.fretron.resources

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/server/v1")
class MyResource {

    @GET
    @Path("/status")
    public fun get(): Response {

        return Response.ok().entity("Status of server").build()
    }
//
//    @POST
//    @Path("/emp")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public fun addEmp(emp: String): Response {
        //val createdEmp =  service.createEmp(emp);
        // if(emp.name == null) throw Exception("ahda ")
        // return repo.saveEmp(emp)

        // list.add(emp)
        //

        // return createEmp;
//    }


}