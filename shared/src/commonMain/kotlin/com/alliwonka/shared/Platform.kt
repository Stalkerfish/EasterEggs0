package com.alliwonka.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


