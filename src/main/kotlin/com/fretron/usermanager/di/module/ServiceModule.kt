package com.fretron.usermanager.di.module

import com.fretron.usermanager.repository.UserRepository
import com.fretron.usermanager.service.Service
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ServiceModule {
    @Provides
    @Named("service")
    fun provideService(@Named("userRepository") userRepository: UserRepository):Service{
        return Service(userRepository)
    }
}