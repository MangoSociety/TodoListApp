package com.example.kotlin_practice.extension

fun MutableList<Int>.swap(index1: Int, index2: Int){
    if (index1 in 0 until this.size && index2 in 0 until this.size) {
        val timeBox = this[index1]
        this[index1] = this[index2]
        this[index2] = timeBox
    }
}

fun main() {
    val list = mutableListOf(1, 2, 3, 4)


    list.swap(1, 3)
    println(list) // Должно вывести: [1, 4, 3, 2]
}