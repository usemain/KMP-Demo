package com.demo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.demo.extensions.back
import kmp_demo.composeapp.generated.resources.Res
import kmp_demo.composeapp.generated.resources.Undefined
import kmp_demo.composeapp.generated.resources.DetailScreen
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navCtrl: NavController) {
    val title = when (navCtrl.currentBackStackEntry?.destination?.route) {
        "DetailScreen" -> stringResource(Res.string.DetailScreen)
        else -> stringResource(Res.string.Undefined)
    }

    Surface {
        CenterAlignedTopAppBar(
            modifier = Modifier.padding(horizontal = 10.dp),
            title = {
                Text(
                    title,
                    style = TextStyle(
                        fontSize = 18.sp,
                    ),
                )
            },
            navigationIcon = {
                Box(
                    modifier = Modifier.clip(CircleShape).size(24.dp).background(Color(0xFFEC6A5E))
                        .clickable {
                            navCtrl.back()
                        },
                ) {
                    Icon(
                        Icons.Rounded.Close,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp).align(Alignment.Center),
                        tint = Color(0xFF8B1A10)
                    )
                }
            },
        )
    }
}
