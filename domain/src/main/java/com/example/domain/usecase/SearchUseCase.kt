package com.example.domain.usecase

import com.example.domain.model.Student
import com.example.domain.repository.StudentRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: StudentRepository) {
    suspend fun invoke(student: Student){
        repository.searchStudent(student)
    }
}