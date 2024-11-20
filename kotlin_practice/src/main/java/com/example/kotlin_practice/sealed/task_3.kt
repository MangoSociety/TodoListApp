package com.example.kotlin_practice.sealed

sealed class Result
// TODO: Определите классы Success и Error, наследующие от Result
    class Success():Result()
    class Error():Result()

//fun performOperation(): Result {
    // В этом примере всегда возвращаем успех
//    return Success("Operation completed")
//}

fun main() {
//    val result = performOperation()
//    when (result) {
//        is Success -> println(result.data)
//        is Error -> println("Error: ${result.message}")
//    }
}