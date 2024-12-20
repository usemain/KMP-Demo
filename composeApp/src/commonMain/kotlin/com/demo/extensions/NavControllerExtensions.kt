package com.demo.extensions

import androidx.navigation.NavController

fun NavController.back() {
    if (previousBackStackEntry != null) {
        popBackStack()
    }
}
