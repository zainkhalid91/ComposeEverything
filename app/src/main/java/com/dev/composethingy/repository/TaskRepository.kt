package com.dev.composethingy.repository

import com.dev.composethingy.interfaces.TaskDao
import com.dev.composethingy.taskmanagerapp.roomdb.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: Flow<List<TaskEntity>> = taskDao.getAllTasks()
    suspend fun insert(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    suspend fun update(task: TaskEntity) {
        taskDao.updateTask(task)
    }

    suspend fun delete(task: TaskEntity) {
        taskDao.deleteTask(task)
    }
}