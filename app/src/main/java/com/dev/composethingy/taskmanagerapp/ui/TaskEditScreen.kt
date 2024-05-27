package com.dev.composethingy.taskmanagerapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.composethingy.taskmanagerapp.roomdb.TaskEntity

@Composable
fun TaskEditScreen(
    task: TaskEntity?, onSave: (String, String) -> Unit, onCancel: () -> Unit
) {
    var title by remember {
        mutableStateOf(task?.title ?: "")
    }

    var description by remember {
        mutableStateOf(task?.description ?: "")
    }

    Column(
        modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(value = title, onValueChange = { title = it }, label = { Text(text = "Title") })

        TextField(value = description,
            onValueChange = { description = it },
            label = { Text(text = "Description") })

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onCancel) {
                Text(text = "Cancel")
            }


            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = { onSave(title, description) }) {
                Text(text = "Save")

            }
        }

    }
}