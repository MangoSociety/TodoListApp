package com.example.kotlin_practice.exam.easy

data class Person(
    val name: String,
    val age: Int
)

fun updateAge(person: Person, newAge: Int): Person {
    // Создать копию person с новым возрастом
    val name = person.name
    val personWithNewAge = person.copy(name, newAge)
    return personWithNewAge
}

fun main() {
    val person1 = Person("Lilia", 26)
    val updatePerson1 = updateAge(person1,27)
    println(person1)
    println(updatePerson1)

}