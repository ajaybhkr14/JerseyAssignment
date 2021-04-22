package com.fretron.usermanager.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConfigurationModule {


    private val HOST_NAME: String = "http://localhost/"
    private val PORT: Int = 8080
    @Provides
    @Named("host.url")
    fun getHostName():String{
    return HOST_NAME
    }
    @Provides
    @Named("host.port")
    fun getPortName():Int{
        return PORT
    }
}