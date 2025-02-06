package com.example.di

import com.example.data.repository.StudentRepositoryImpl
import com.example.domain.repository.StudentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule{
    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: StudentRepositoryImpl
    ): StudentRepository

}