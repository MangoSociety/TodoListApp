package com.example.kotlin_practice.data

data class Person(val name: String, val age: Int)

fun updateAge(age: Int): Person {
    val person = Person("Alice", 30)
    // TODO: Создайте копию person с новым возрастом
    return person.copy(age = age)
}