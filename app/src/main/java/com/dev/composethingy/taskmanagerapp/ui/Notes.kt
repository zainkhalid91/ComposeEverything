package com.dev.composethingy.taskmanagerapp.ui

import TaskManagerApp
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.dev.composethingy.database.TaskDatabase
import com.dev.composethingy.repository.TaskRepository
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModel
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModelFactory

@Composable
fun Notes(context: Context) {
    val database = Room.databaseBuilder(
        context,
        TaskDatabase::class.java,
        TaskDatabase.DATABASE_NAME
    ).build()

    val repository = TaskRepository(database.taskDao())


    val taskViewModel: TaskViewModel =
        viewModel(factory = TaskViewModelFactory(repository))
    TaskManagerApp(viewModel = taskViewModel)


}