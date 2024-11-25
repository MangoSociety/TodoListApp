package com.example.kotlin_practice.exam.easy

// Задание: Написать функцию, которая возвращает описание оценки
fun getGradeDescription(grade: Int): String {
    // 5 - "Отлично"
    // 4 - "Хорошо"
    // 3 - "Удовлетворительно"
    // 2 - "Неудовлетворительно"
    // остальное - "Некорректная оценка"
    return when(grade) {
         5 -> "Отлично"
         4 -> "Хорошо"
         3 -> "Удовлетворительно"
         2 -> "Неудовлетворительно"
         else -> "Некорректная оценка"
    }
}

fun main(){
    println(getGradeDescription(1))
    println(getGradeDescription(2))
    println(getGradeDescription(3))
    println(getGradeDescription(4))
    println(getGradeDescription(5))
}