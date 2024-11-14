package com.example.kotlin_practice.extension

fun List<Int>.sum(): Int{
    var summ = this.reduce { acc, i -> i + acc }
//    this.forEach { number -> summ += number }
    return summ
}

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.sum()) // Должно вывести: 10
}