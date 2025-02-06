package com.example.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")

data class Student(
    @PrimaryKey @ColumnInfo("student_id")
    var id : Int,
    var name : String
)