package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> get() = _students

    suspend fun insertStudent(student: Student){

        insertUseCase.invoke(student)
    }

    suspend fun searchStudent(student: Student){
        searchUseCase.invoke(student)
    }

    fun getAllUStudent(){
        getAllUserCase.invoke()
    }

}