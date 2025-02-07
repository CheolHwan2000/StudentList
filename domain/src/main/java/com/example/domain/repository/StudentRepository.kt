package com.example.domain.repository

import androidx.lifecycle.LiveData
import com.example.domain.model.Student


interface StudentRepository {
    suspend fun insertStudent(student : Student)
    suspend fun deleteStudent(student : String)
    suspend fun searchStudent(student : String):LiveData<List<Student>>
    fun getAllStudent():LiveData<List<Student>>
}