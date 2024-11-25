package com.example.kotlin_practice.exam.easy

// Задание: Исправить код так, чтобы он корректно работал с null
fun processUser(name: String?, age: Int?): String {
    val correctName = name?: "Unknown"
    val correctAge = age?: 18

    return ("Name: $correctName, Age: $correctAge")

    // Нужно вывести имя и возраст,
    // если age null - использовать 18 как значение по умолчанию
    // если name null - использовать "Unknown"
}
fun main(){
    val person = listOf(processUser("Kirill",20),
    processUser("Sosha",15), processUser("Mila",null),processUser(null,25),
    )
    println(person)
}