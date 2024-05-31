package com.dev.composethingy

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.composethingy.musicapp.ui.WelcomeScreen
import com.dev.composethingy.taskmanagerapp.ui.Notes

@Composable
fun NavGraph(startDestination: String = "main", context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("main") { MainScreen(navController) }
        composable("notes") { Notes(context = context) }
        composable("music") { WelcomeScreen(onGetStartedClick = {}) }
    }
}