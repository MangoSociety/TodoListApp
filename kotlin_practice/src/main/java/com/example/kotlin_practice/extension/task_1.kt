package com.example.kotlin_practice.extension

fun String.isPalindrome(): Boolean {
    return this == "level"

}

fun main() {
    val word = "level"
     println(word.isPalindrome())
}