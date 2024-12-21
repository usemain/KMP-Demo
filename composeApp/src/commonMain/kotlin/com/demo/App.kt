package com.demo

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.demo.common.DarkBgTheme
import com.demo.screens.layout.LayoutScreen

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
            Navigator(LayoutScreen)
        }
    }
}
