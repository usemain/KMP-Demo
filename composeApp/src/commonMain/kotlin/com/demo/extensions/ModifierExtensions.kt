package com.demo.extensions

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

fun Modifier.click(
    onClick: () -> Unit
): Modifier {
    return this.then(Modifier.clickable(
        indication = null, interactionSource = null
    ) { onClick() })
}
