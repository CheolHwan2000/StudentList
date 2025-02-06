package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.model.Student
import com.example.domain.usecase.GetAllUseCase
import com.example.domain.usecase.InsertUseCase
import com.example.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUserCase: GetAllUseCase,
    private val insertUseCase: InsertUseCase,
    private val searchUseCase: SearchUseCase) :ViewModel(){

    suspend fun insertStudent(student: Student){

        insertUseCase.invoke(student)
    }

    suspend fun searchStudent(student: Student){
        searchUseCase.invoke(student)
    }

    suspend fun getAllUStudent(){
        getAllUserCase.invoke()
    }

}