package com.dev.composethingy.taskmanagerapp.roomdb

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.dev.composethingy.database.TaskDatabase
import com.dev.composethingy.repository.TaskRepository
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModel
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModelFactory

@Composable
fun InitializeDatabase(context: Context): TaskViewModel {
    val database = Room.databaseBuilder(
        context.applicationContext,
        TaskDatabase::class.java,
        TaskDatabase.DATABASE_NAME
    ).build()

    val repository = TaskRepository(database.taskDao())

    return viewModel(factory = TaskViewModelFactory(repository))
}