package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.data.local.MyDao
import com.example.domain.model.Student
import com.example.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(private val myDao : MyDao) : StudentRepository {
    override suspend fun insertStudent(student: Student) {
        myDao.insertStudentList(com.example.data.local.Student(student.id,student.name))
    }

    override suspend fun searchStudent(student: Student) {

    }

    override suspend fun getAllStudent(): LiveData<List<Student>> {
        return myDao.getAllStudentList().map { it.map { Student(it.id, it.name)  } }
    }
}