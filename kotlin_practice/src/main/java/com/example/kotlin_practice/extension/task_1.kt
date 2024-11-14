package com.example.kotlin_practice.extension

fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}

fun main() {
    val word = "kekd"
     println(word.isPalindrome())
}