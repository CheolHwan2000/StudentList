package com.example.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {
    @Query("SELECT * FROM student_table")
    fun getAllStudentList() : LiveData<List<Student>>

    @Query("SELECT * FROM student_table WHERE name = :student")
    fun getSearchStudent(student : String) : LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentList(student: Student)

    @Query("DELETE FROM student_table WHERE name = :student")
    suspend fun deleteStudentList(student: String)
    @Delete
    suspend fun deleteAllStudent(student: Student)
}