package com.dev.composethingy.taskmanagerapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.composethingy.taskmanagerapp.models.Task
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(
    viewModel: TaskViewModel,
    onAddTask: () -> Unit,
    onEditTask: (Int) -> Unit
) {
    Column {
        Button(onClick = onAddTask,
            modifier = Modifier.padding(16.dp)) {
            Text("Add Task")
        }

        LazyColumn {
            items(viewModel.tasks) { task ->
                TaskItem(task = task, onEditTask = { onEditTask(task.id) }, onDeleteTask = { viewModel.deleteTask(task.id) })
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onEditTask: () -> Unit, onDeleteTask:  () -> Unit){
    Row (
         modifier = Modifier
             .fillMaxWidth()
             .padding(8.dp),
        horizontalArrangement =  Arrangement.SpaceBetween
    ){
        Column {
                Text(task.title, style = MaterialTheme.typography.headlineMedium)
            Text(task.description, style = MaterialTheme.typography.bodySmall)
        }
        Row {
            IconButton(onClick = onEditTask) {
                Icon(Icons.Default.Edit, contentDescription = "Edit Task")
            }
            IconButton(onClick = onDeleteTask) {
                Icon(Icons.Default.Delete, contentDescription = "Delete Task")

            }
        }
    }
}