package com.dev.composethingy

import TaskManagerApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: TaskViewModel = viewModel()
            TaskManagerApp(viewModel = viewModel)

        }
    }
}
