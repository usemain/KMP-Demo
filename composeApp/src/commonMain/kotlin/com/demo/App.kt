package com.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kmp_demo.composeapp.generated.resources.Res
import kmp_demo.composeapp.generated.resources.back
import kmp_demo.composeapp.generated.resources.home
import kmp_demo.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

fun NavController.safePopBackStack() {
    if (previousBackStackEntry != null) {
        popBackStack()
    }
}

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
            NavHost(navController = navCtrl, startDestination = "LayoutScreen") {
                composable("LayoutScreen") {
                    LayoutScreen(navCtrl)
                }
                composable("DetailsScreen") {
                    DetailsScreen(navCtrl)
                }
            }
        }
    }
}

data class TabItem(val label: String, val icon: ImageVector, val resource: StringResource)

@Composable
fun LayoutScreen(navCtrl: NavController) {
    var tabLabel by remember { mutableStateOf("Home") }

    val tabs = listOf(
        TabItem("Home", Icons.Sharp.Home, Res.string.home),
        TabItem("Settings", Icons.Sharp.Settings, Res.string.settings)
    )

    Scaffold(bottomBar = {
        NavigationBar {
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
    }) {
        when (tabLabel) {
            "Home" -> HomeScreen(navCtrl)
            "Settings" -> SettingsScreen()
        }
    }
}

@Composable
fun HomeScreen(navCtrl: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navCtrl.navigate("DetailsScreen") }) {
            Text("Details")
        }
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("SettingsScreen")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navCtrl: NavController) {
    Scaffold(topBar = {
        Surface {
            CenterAlignedTopAppBar(
                title = {
                    Text("Details")
                },
                navigationIcon = {
                    Box(modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = null,
                    ) {
                        navCtrl.safePopBackStack()
                    }) {
                        Icon(Icons.AutoMirrored.Sharp.ArrowBack, stringResource(Res.string.back))
                    }
                },
                modifier = Modifier,
            )
        }
    }) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.clickable(
                indication = null, interactionSource = null
            ) {
                navCtrl.safePopBackStack()
            }) {
                Text("DetailsScreen")
            }
        }
    }
}
