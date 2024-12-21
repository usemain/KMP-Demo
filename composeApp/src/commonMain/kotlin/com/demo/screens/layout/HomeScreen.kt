package com.demo.screens.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.demo.extensions.click
import com.demo.screens.detail.DetailScreen

object HomeScreen : Screen {

    @Composable
    override fun Content() {
//        val nav = LocalNavigator.currentOrThrow

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(10) { index ->
                BlueBoxItem(text = "Item ${index + 1}", onClick = {
//                    nav.push(DetailScreen)
                })
            }
        }
    }
}

@Composable
fun BlueBoxItem(
    text: String, onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth().height(200.dp).background(
            color = Color(0xFF1197FF), shape = RoundedCornerShape(8.dp)
        ).click(onClick), contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, color = Color.White
        )
    }
}
