package com.example.kotlin_practice.extension

fun String.lastChar(): Char {
//    val timeBox: MutableList<Char> = this.filter { it.isLetter() }.toMutableList()
//    return timeBox.last()
    val count = this.length
    val lC = this.get(count-1)
    return lC
}

fun main() {
    val str = "Kotlin"
    println(str.lastChar().toString()) // Должно вывести: n
}