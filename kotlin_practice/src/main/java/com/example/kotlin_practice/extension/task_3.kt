package com.example.kotlin_practice.extension

fun String.lastChar(): Char {
//    val timeBox: MutableList<Char> = this.filter { it.isLetter() }.toMutableList()
//    return timeBox.last()
    val lC = this.replace(" ","")
    val count =lC.length
    return lC.get(count-1)
}

fun main() {
    val str = "Kotlin "
    println(str.lastChar().toString()) // Должно вывести: n
}