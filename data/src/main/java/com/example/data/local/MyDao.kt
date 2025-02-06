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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentList(student: Student)

    @Delete
    suspend fun deleteStudentList(student: Student)
}