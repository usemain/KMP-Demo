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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.common.DarkBgTheme
import com.demo.routes.getRoutesScreen

@Preview
@Composable
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme().copy(
            surface = DarkBgTheme, background = DarkBgTheme, surfaceContainer = DarkBgTheme
        ) else lightColorScheme().copy(
            surface = lightColorScheme().background,
            surfaceContainer = lightColorScheme().background
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val navCtrl = rememberNavController()

            NavHost(
                navController = navCtrl,
                startDestination = "LayoutScreen",
                sizeTransform = null,
                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
                popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
                popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
            ) {
                getRoutesScreen().forEach { screen ->
                    composable(screen.route) {
                        screen.content(navCtrl)
                    }
                }
            }
        }
    }
}
