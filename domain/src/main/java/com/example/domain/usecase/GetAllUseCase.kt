package com.example.domain.usecase

import androidx.lifecycle.LiveData
import com.example.domain.model.Student
import com.example.domain.repository.StudentRepository
import javax.inject.Inject

class GetAllUseCase @Inject constructor(
    private val repository: StudentRepository
){
    operator fun invoke():LiveData<List<Student>>{
        return repository.getAllStudent()
    }
}