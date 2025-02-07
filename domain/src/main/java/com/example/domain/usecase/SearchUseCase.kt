package com.example.domain.usecase

import androidx.lifecycle.LiveData
import com.example.domain.model.Student
import com.example.domain.repository.StudentRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    suspend operator fun invoke(student: String): LiveData<List<Student>> {
        return repository.searchStudent(student)
    }
}