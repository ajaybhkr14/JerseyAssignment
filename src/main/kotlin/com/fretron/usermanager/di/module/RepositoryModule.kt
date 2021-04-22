package com.fretron.usermanager.di.module

import com.fretron.usermanager.repository.UserRepository
import dagger.Module
import dagger.Provides
import org.glassfish.grizzly.http.server.util.Mapper
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    @Named("userRepository")
    fun provideUserRepository():UserRepository{
        return UserRepository()
    }

}