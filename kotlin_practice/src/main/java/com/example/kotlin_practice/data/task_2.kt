package com.example.kotlin_practice.data

data class Point(val x: Int, val y: Int)

// TODO: Переопределите метод equals для сравнения только координат x

fun main() {
    val p1 = Point(1, 2)
    val p2 = Point(1, 3)
    println(p1 == p2) // Должно вывести: true
}