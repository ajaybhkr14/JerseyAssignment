package com.fretron.usermanager.Component

import com.fretron.usermanager.module.*
import com.mongodb.connection.Server
import dagger.Component
import org.glassfish.grizzly.http.server.HttpServer
import org.openjdk.tools.javac.comp.Modules
import javax.inject.Singleton

@Singleton
@Component(modules= [HttpModule::class, ConfigurationModule::class,RepositoryModule::class,ServiceModule::class])
interface AppComponent {
    fun server(): HttpServer
}