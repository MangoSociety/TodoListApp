package com.example.kotlin_practice.extension

fun String.lastChar(str: String): Char {
    val timeBox: MutableList<Char> = this.filter { it.isLetter() }.toMutableList()

    return timeBox.last()
}

fun main() {
    val str = "Kotlin"
    println(str.lastChar(str).toString()) // Должно вывести: n
}