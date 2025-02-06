package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.MyDao
import com.example.data.local.MyDatabase
import com.example.data.repository.StudentRepositoryImpl
import com.example.domain.repository.StudentRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // 앱 전체에서 사용될 모듈
object AppModule {
    @Provides
    @Singleton
    fun provideStudentRepository(myDao: MyDao): StudentRepository {
        return StudentRepositoryImpl(myDao)
    }

    // 데이터베이스 제공
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "school_database"
        ).build()
    }

    // DAO 제공
    @Provides
    fun provideMyDao(database: MyDatabase): MyDao {
        return database.myDao()
    }
}