package com.example.kotlin_practice.generic

// TODO: Реализуйте обобщенную функцию printList
fun <T>printList(data:List<T>) {
    for (i in data) {
        print("$i")
    }
        println()
}

fun main() {
    val intList = listOf(1, 2, 3)
    val stringList = listOf("a", "b", "c")

    printList(intList)    // Ожидаемый вывод: 1 2 3
    printList(stringList) // Ожидаемый вывод: a b c
}