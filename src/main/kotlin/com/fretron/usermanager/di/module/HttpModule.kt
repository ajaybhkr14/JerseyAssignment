package com.fretron.usermanager.di.module

import com.fretron.usermanager.resource.Resource
import dagger.Module
import dagger.Provides
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI
import javax.inject.Named
import javax.ws.rs.core.UriBuilder

@Module
class   HttpModule {

    @Provides
    fun provideResource(resource:Resource):ResourceConfig{
        return ResourceConfig().register(resource)

    }
    @Provides
    fun server(@Named("host.url") host:String, @Named("host.port") port :Int, config: ResourceConfig):HttpServer{
        val baseUri: URI = UriBuilder.fromUri(host).port(port).build()
        return GrizzlyHttpServerFactory.createHttpServer(baseUri,config)
    }
}