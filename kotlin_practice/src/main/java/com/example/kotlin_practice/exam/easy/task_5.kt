package com.example.kotlin_practice.exam.easy

import java.util.stream.Collectors.toList

// Задание: Отфильтровать список чисел, оставить только четные
// и умножить каждое на 2
fun processNumbers(numbers: List<Int>): List<Int> {
    // Использовать filter и map
    val sortedList = numbers
        .filter { it % 2 == 0  }
    val multiplySortedList = sortedList.map { it * 2 }

//    println(sortedList)
    return multiplySortedList
}

fun main(){
    val listOfNum = processNumbers(listOf(1,2,3,4,5,6,7,8,9))


    println(listOfNum)
}