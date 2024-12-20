package com.demo.screens.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import kmp_demo.composeapp.generated.resources.Res
import kmp_demo.composeapp.generated.resources.Home
import kmp_demo.composeapp.generated.resources.Settings
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

data class TabItem(val label: String, val icon: ImageVector, val resource: StringResource)

@Composable
fun LayoutScreen(navCtrl: NavController) {
    var tabLabel by remember { mutableStateOf("Home") }

    val tabs = listOf(
        TabItem("Home", Icons.Sharp.Home, Res.string.Home),
        TabItem("Settings", Icons.Sharp.Settings, Res.string.Settings)
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
            ) {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        label = { Text(stringResource(tab.resource)) },
                        icon = {
                            Icon(
                                tab.icon, contentDescription = null
                            )
                        },
                        selected = tabLabel == tab.label,
                        onClick = {
                            tabLabel = tab.label
                        },
                    )
                }
            }
        },
    ) {
        when (tabLabel) {
            "Home" -> HomeScreen(navCtrl)
            "Settings" -> SettingsScreen()
        }
    }
}
