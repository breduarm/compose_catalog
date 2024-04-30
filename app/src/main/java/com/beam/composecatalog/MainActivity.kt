package com.beam.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.beam.composecatalog.domain.model.Routes
import com.beam.composecatalog.domain.model.Routes.Screen1
import com.beam.composecatalog.domain.model.Routes.Screen2
import com.beam.composecatalog.domain.model.Routes.Screen3
import com.beam.composecatalog.domain.model.Routes.Screen4
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_catalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val navController = rememberNavController()
//
//                    NavHost(navController = navController, startDestination = Screen1.route) {
//                        composable(route = Screen1.route) { ScreenOne(navController) }
//                        composable(route = Screen2.route) { ScreenTwo(navController) }
//                        composable(route = Screen3.route) { ScreenThree(navController) }
//                        composable(
//                            route = Screen4("{name}").route,
//                            arguments = listOf(
//                                navArgument("name") {
//                                    type = NavType.StringType
//                                }
//                            )
//                        ) { backStackEntry ->
//                            ScreenFour(
//                                navController = navController,
//                                name = backStackEntry.arguments?.getString("name")!!
//                            )
//                        }
//                        composable(
//                            route = Routes.Screen5.route,
//                            arguments = listOf(
//                                navArgument("name") { defaultValue = "Default value" }
//                            )
//                        ) { backStackEntry ->
//                            ScreenFive(
//                                navController = navController,
//                                name = backStackEntry.arguments?.getString("name")
//                            )
//                        }
//                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        MyCrossfadeAnimation()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_catalogTheme {
        MyState()
    }
}