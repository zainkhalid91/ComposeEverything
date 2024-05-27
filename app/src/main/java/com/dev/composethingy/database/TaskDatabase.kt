package com.dev.composethingy.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.composethingy.interfaces.TaskDao
import com.dev.composethingy.taskmanagerapp.roomdb.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "tasks_db"
    }
}