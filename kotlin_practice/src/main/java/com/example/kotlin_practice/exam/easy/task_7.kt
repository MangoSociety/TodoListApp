package com.example.kotlin_practice.exam.easy

// Задание: Использовать lazy для отложенной инициализации
class User(
    val firstName: String,
    val lastName: String
) {
    // Изменить свойство fullInfo, которое будет вычисляться только при первом обращении
    val fullInfo: String by lazy {
        println("Pricessing...")
        "$firstName $lastName"

    }
}

fun main(){
    val getFullInfo = User(firstName = "Lilu", lastName =  "Nafikova")


    println("Full info: ${getFullInfo.fullInfo}")

}