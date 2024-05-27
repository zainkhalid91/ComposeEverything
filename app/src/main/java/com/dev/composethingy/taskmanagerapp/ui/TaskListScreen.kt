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
import com.dev.composethingy.taskmanagerapp.roomdb.TaskEntity

@Composable
fun TaskListScreen(
    tasks: List<TaskEntity>,
    onAddTask: () -> Unit,
    onEditTask: (Int) -> Unit,
    onDeleteTask: (TaskEntity) -> Unit
) {
    Column {
        Button(onClick = onAddTask,
            modifier = Modifier.padding(16.dp)) {
            Text("Add Task")
        }

        LazyColumn {
            items(tasks) { task ->
                TaskItem(
                    task = task,
                    onEditTask = { onEditTask(task.id) },
                    onDeleteTask = { onDeleteTask(task) })
            }
        }
    }
}

@Composable
fun TaskItem(task: TaskEntity, onEditTask: () -> Unit, onDeleteTask: () -> Unit) {
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