package com.demo.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.demo.screens.detail.DetailScreen
import com.demo.screens.layout.LayoutScreen

data class ScreenConfig(
    val route: String, val content: @Composable (navCtrl: NavHostController) -> Unit
)

fun getRoutesScreen(): List<ScreenConfig> {
    return listOf(
        ScreenConfig(
            route = "LayoutScreen",
            content = { navCtrl -> LayoutScreen(navCtrl) },
        ), ScreenConfig(
            route = "DetailScreen",
            content = { navCtrl -> DetailScreen(navCtrl) },
        )
    )
}
