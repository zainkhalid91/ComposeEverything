import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dev.composethingy.taskmanagerapp.ui.TaskEditScreen
import com.dev.composethingy.taskmanagerapp.ui.TaskListScreen
import com.dev.composethingy.taskmanagerapp.viewmodel.TaskViewModel

@Composable
fun TaskManagerApp(viewModel: TaskViewModel) {
    val allTasks by viewModel.allTasks.collectAsState(initial = emptyList())
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "taskList") {
        composable("taskList") {
            TaskListScreen(
                tasks = allTasks,
                onAddTask = { navController.navigate("taskEdit/-1") },
                onEditTask = { taskId -> navController.navigate("taskEdit/$taskId") },
                onDeleteTask = { task -> viewModel.deleteTask(task) }

            )
        }
        composable(
            route = "taskEdit/{taskId}",
            arguments = listOf(navArgument("taskId") { defaultValue = -1 })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: -1
            val task = allTasks.find { it.id == taskId }
            TaskEditScreen(
                task = task,
                onSave = { title, description ->
                    if (task == null) {
                        viewModel.addTask(title, description)
                    } else {
                        viewModel.editTask(task.id, title, description)
                    }
                    navController.popBackStack()
                },
                onCancel = { navController.popBackStack() }
            )
        }
    }
}
