package org.fretron.resources

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI
import javax.ws.rs.core.UriBuilder

fun main() {

    val baseUri :URI = UriBuilder.fromUri("http://localhost/").port(8080).build()
    val config :ResourceConfig =  ResourceConfig(MyResource::class.java)
     var server :HttpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, config)
}