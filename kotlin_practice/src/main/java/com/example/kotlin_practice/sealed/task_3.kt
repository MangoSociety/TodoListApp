package com.example.kotlin_practice.sealed

sealed class Result {
    data class Success(val data: String): Result()
    data class Error(val message: String): Result()
}


fun performOperation(): Result {
//     В этом примере всегда возвращаем успех
    return Result.Success("Operation completed")
}

fun main() {
    val result = performOperation()
    when (result) {
        is Result.Success -> println(result.data)
        is Result.Error -> println("Error: ${result.message}")
    }
}