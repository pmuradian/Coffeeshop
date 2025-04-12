package org.example.coffebrewer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform