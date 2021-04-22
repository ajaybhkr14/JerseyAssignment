package com.fretron.usermanager

import com.fretron.usermanager.di.Component.DaggerAppComponent
import com.fretron.usermanager.repository.UserRepository
import com.fretron.usermanager.service.Service
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI
import javax.ws.rs.core.UriBuilder

fun main() {
val component = DaggerAppComponent.builder().build()
    component.server().start()

//
//    val baseUri: URI = UriBuilder.fromUri("http://localhost/").port(8080).build()
//    val repository = UserRepository()
//    val service = Service(repository)
//
//    val resource = Resource(service)
//    val config: ResourceConfig = ResourceConfig().register(resource)
//    var server: HttpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri,config ,false)
//    server.start()
}