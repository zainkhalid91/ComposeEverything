package com.dev.composethingy.taskmanagerapp.viewmodel

import androidx.compose.runtime.internal.illegalDecoyCallException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.dev.composethingy.repository.TaskRepository
import com.dev.composethingy.taskmanagerapp.roomdb.TaskEntity
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    val allTasks = repository.allTasks


    fun addTask(title: String, description: String) = viewModelScope.launch {
        val newTask = TaskEntity(title = title, description = description)
        repository.insert(newTask)
    }

    fun editTask(id: Int, newTitle: String, newDescription: String) = viewModelScope.launch {
        val updateTask = TaskEntity(id = id, title = newTitle, description = newDescription)
        repository.update(updateTask)
    }

    fun deleteTask(task: TaskEntity) = viewModelScope.launch {
        repository.delete(task)

    }
}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        @Suppress("UNREACHABLE_CODE")
        throw illegalDecoyCallException("Unknown Viewmodel Class")
    }
}