package com.example.kotlin_practice.extension

fun List<Int>.secondOrNull():Int?{
    if (this.size > 2){
        return this[1]
    } else return null
}

fun main() {
    val list = listOf(1, 2, 3)
    println(list.secondOrNull()) // Должно вывести: 2

    val shortList = listOf(1)
    println(shortList.secondOrNull()) // Должно вывести: null
}