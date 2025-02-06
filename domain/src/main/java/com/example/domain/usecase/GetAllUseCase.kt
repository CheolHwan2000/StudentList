package com.example.domain.usecase

import com.example.domain.repository.StudentRepository
import javax.inject.Inject

class GetAllUseCase @Inject constructor(private val repository: StudentRepository) {
    suspend fun invoke(){
        repository.getAllStudent()
    }
}