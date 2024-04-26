package com.beam.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.beam.composecatalog.domain.model.Routes

@Composable
fun ScreenOne(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Screen 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Screen2.route) }
        )
    }
}

@Composable
fun ScreenTwo(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = "Screen 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Screen3.route) }
        )
    }
}

@Composable
fun ScreenThree(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = "Screen 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Screen1.route) }
        )
    }
}