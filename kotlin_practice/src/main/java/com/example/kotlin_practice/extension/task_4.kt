package com.example.kotlin_practice.extension

fun Int.isEven(): Boolean {
    return this % 2 == 0
}
fun main() {
    val number = 5

    println(number.isEven()) // Должно вывести: true

}