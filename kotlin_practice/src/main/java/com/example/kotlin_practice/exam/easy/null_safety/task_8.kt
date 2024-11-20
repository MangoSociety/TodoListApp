package com.example.kotlin_practice.exam.easy.null_safety

// Задача 1: Реализовать безопасную цепочку вызовов
data class Address(val street: String?, val city: String?, val country: String?)
data class Company(val name: String?, val address: Address?)
data class Employee(val name: String?, val company: Company?)

class EmployeeProcessor {
    // Нужно получить страну сотрудника, если все данные доступны
    // Если какие-то данные отсутствуют, вернуть "Unknown"
    // Реализовать тремя способами:
    // 1. Using safe calls (?.)
    // 2. Using let
    // 3. Using run
    fun getEmployeeCountry(employee: Employee?): String {
        // Ваше решение
        return ""
    }
}