package com.example.domain.usecase

import com.example.domain.repository.StudentRepository
import javax.inject.Inject

class DeleteUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    suspend operator fun invoke(student: String){
        repository.deleteStudent(student)

    }
}