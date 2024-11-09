package com.example.kotlin_practice.generic

interface Producer<out T> {
    fun produce(): T
}

interface Consumer<in T> {
    fun consume(item: T)
}

// TODO: Реализуйте функцию copyData

fun main() {
    val producer = object : Producer<String> {
        override fun produce() = "Hello"
    }

    val consumer = object : Consumer<Any> {
        override fun consume(item: Any) {
            println(item)
        }
    }

//    copyData(producer, consumer) // Ожидаемый вывод: Hello
}