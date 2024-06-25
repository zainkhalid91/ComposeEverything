package com.dev.composethingy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dev.composethingy.ui.theme.ComposeThingyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*    val database = Room.databaseBuilder(
                applicationContext,
                TaskDatabase::class.java,
                TaskDatabase.DATABASE_NAME
            ).build()

            val repository = TaskRepository(database.taskDao())*/

        setContent {
            ComposeThingyTheme {

//                NavGraph("dashboard", applicationContext)
                NavGraph("main", applicationContext)
            }
        }
    }
}

