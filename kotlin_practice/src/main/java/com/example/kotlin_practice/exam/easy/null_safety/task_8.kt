package com.example.kotlin_practice.exam.easy.null_safety

import com.example.kotlin_practice.exam.easy.getGradeDescription

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
       val employeeCountry = employee?.company?.address?.country
        return employeeCountry?: "Unknown"

    }
    fun getEmployeeCountryUsingRun(employee: Employee?): String {
        return employee?.run {
            company?.run {
                address?.run {
                    country
                }
            }
        } ?: "Unknown"
    }
    fun getEmployeeCountryUsingLet(employee: Employee?): String{
        var country = "Unknown"
        employee?.let {emp ->
            emp.company?.let { comp ->
                comp.address?.let { addr ->
                    country = addr.country?: "Unknown"
                }
            }
        }
        return country
    }
}

fun main() {
    val address =
//        listOf(
//        Address("Main st", "New-York", "USA"),
//        Address("Second st", "Moscow", "USSR"),
        Address("Third st", "Berlin", "Germany")
    //        )
    val company =
//        listOf(
//        Company("ARS", address),
//        Company("BRS", address),
        Company("DRS", address)
//        )
    val employee =
//        listOf(
//        Employee("Sasha", company),
//        Employee("Masha", company),
        Employee("Midha", company)
//        )

    val result = EmployeeProcessor().getEmployeeCountry(employee)
    println(result)
    val result2 = EmployeeProcessor().getEmployeeCountryUsingRun(employee)
    println(result2)
    val result3 = EmployeeProcessor().getEmployeeCountryUsingLet(employee)
    println(result3)
}
