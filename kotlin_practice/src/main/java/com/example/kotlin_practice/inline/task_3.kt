package com.example.kotlin_practice.inline

// TODO: Реализуйте функцию printTypeName
inline fun <reified T> printTypeName() {
    println(T::class.java)
}

fun main() {

    printTypeName<String>() // Ожидаемый вывод: java.lang.String
    printTypeName<Int>()    // Ожидаемый вывод: java.lang.Integer
}