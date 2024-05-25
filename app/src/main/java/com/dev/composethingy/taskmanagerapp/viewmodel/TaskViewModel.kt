package com.dev.composethingy.taskmanagerapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dev.composethingy.taskmanagerapp.models.Task

class TaskViewModel : ViewModel() {
    private var nextId = 0
    var tasks = mutableStateListOf<Task>()
        private set


    fun addTask(title : String, description : String){
        tasks.add(Task(nextId++, title, description))
    }

    fun editTask(id : Int, newTitle: String, newDescription : String){
        tasks.find { it.id == id }?.let {
            it.title = newTitle
            it.description = newDescription
        }
    }

    fun deleteTask(id : Int){
        tasks.removeAll{it.id == id}
    }
}