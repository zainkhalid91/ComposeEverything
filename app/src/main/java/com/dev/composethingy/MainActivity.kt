package com.dev.composethingy

import TaskManagerApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.dev.composethingy.database.TaskDatabase
import com.dev.composethingy.repository.TaskRepository
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModel
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            TaskDatabase.DATABASE_NAME
        ).build()

        val repository = TaskRepository(database.taskDao())

        setContent {
            val taskViewModel: TaskViewModel =
                viewModel(factory = TaskViewModelFactory(repository))
            TaskManagerApp(viewModel = taskViewModel)

        }
    }
}

