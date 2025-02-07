package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Student
import com.example.domain.usecase.GetAllUseCase
import com.example.domain.usecase.InsertUseCase
import com.example.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUseCase: GetAllUseCase,
    private val insertUseCase: InsertUseCase,
    private val searchUseCase: SearchUseCase) :ViewModel(){

    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> get() = _students

    suspend fun insertStudent(student: Student){
        insertUseCase.invoke(student)
    }

    fun searchStudent(student: String){
        _students.value = emptyList()
//        searchUseCase.invoke(student)
        viewModelScope.launch {
            searchUseCase(student).observeForever { studentList ->
                _students.postValue(studentList ?: emptyList()) // 🔹 null 방지
            }
        }
    }
    fun loadStudents() {
        viewModelScope.launch {
            getAllUseCase().observeForever { studentList ->
                _students.postValue(studentList ?: emptyList()) // 🔹 null 방지
            }
        }
    }

//    fun loadStudents() {
//        viewModelScope.launch {
//            _students.value = getAllUseCase().value
//        }
//    }

//    fun getAllUStudent(){
//        getAllUserCase.invoke()
//    }

}