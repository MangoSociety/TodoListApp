package com.example.kotlin_practice.extension

fun List<Int>.sum(): Int{
    var summ = 0
    this.forEach { number -> summ += number }
    return summ
}

fun main() {
    val numbers = listOf(1, 2, 3, 4,)
    println(numbers.sum()) // Должно вывести: 10
}