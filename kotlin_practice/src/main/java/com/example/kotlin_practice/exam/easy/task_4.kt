package com.example.kotlin_practice.exam.easy

// Задание: Написать extension функцию для String,
// которая проверяет является ли строка email адресом
fun String.isValidEmail(): Boolean {
    // Реализовать простую проверку email
    if(this.contains("@")){
        println("$this может существовать")
    } else println("$this не существует")
    return false

}fun main(){
    val email = "komar90@mail.ru"
    val email2 = "kosar90mail.ru"
    email.isValidEmail()
    email2.isValidEmail()
}