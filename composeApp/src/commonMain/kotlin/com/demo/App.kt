package com.demo

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.screens.detail.DetailScreen
import com.demo.screens.layout.LayoutScreen

var BackgroundTheme = Color(20, 20, 23, 255)

@Composable
@Preview
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme().copy(
            surface = BackgroundTheme, background = BackgroundTheme
        ) else lightColorScheme()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val navCtrl = rememberNavController()

            NavHost(
                navController = navCtrl,
                startDestination = "LayoutScreen",
                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
                popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
                popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
            ) {
                composable("LayoutScreen") {
                    LayoutScreen(navCtrl)
                }
                composable("DetailScreen") {
                    DetailScreen(navCtrl)
                }
            }
        }
    }
}
