package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun myDao() : MyDao
    companion object{
        private var INSTANCE : MyDatabase? = null
        private var MIGRATION_1_2 = object : Migration(1,2){
            override fun migrate(db: SupportSQLiteDatabase) {

            }

        }
        fun getDatabase(context : Context) : MyDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    "school_database"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return INSTANCE as MyDatabase
        }
    }
}