package com.example.kotlin_practice.extension

fun Int.isEven(): Boolean {
    if (this % 2 == 0 ) {
        return true
    }
    return false
}
fun main() {
    val number = 4

    println(number.isEven()) // Должно вывести: true

}