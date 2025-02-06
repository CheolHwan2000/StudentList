package com.example.domain.repository

import androidx.lifecycle.LiveData
import com.example.domain.model.Student


interface StudentRepository {
    suspend fun insertStudent(student : Student)
    suspend fun searchStudent(student : Student)
    fun getAllStudent():LiveData<List<Student>>
}