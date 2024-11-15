package com.example.kotlin_practice.generic

class Box<T>(private val value: T) {
    fun getValue():T{
        return value
    }
}

fun main() {
    val intBox = Box(123)
    val stringBox = Box("Hello")

    println(intBox.getValue())     // Ожидаемый вывод: 123
    println(stringBox.getValue())  // Ожидаемый вывод: Hello
}