package com.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform