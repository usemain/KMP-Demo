package com.demo.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.demo.extensions.back
import com.demo.extensions.click
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
                    modifier = Modifier.click {
                        navCtrl.back()
                    },
                ) {
                    Icon(
                        Icons.AutoMirrored.Sharp.ArrowBack, null
                    )
                }
            },
        )
    }
}
