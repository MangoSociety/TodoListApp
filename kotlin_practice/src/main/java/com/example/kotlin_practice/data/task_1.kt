package com.example.kotlin_practice.data

data class Person(val name: String, val age: Int,)

fun updateAge(age: Int): Person {
    val person = Person("Alice", 30)
    person.copy(age = 22)
    val (q,_) = person
    // TODO: Создайте копию person с новым возрастом
    return person.copy(age = age)
}


// data class CounterEntity(val number: Int)
// val state = CounterEntity(0)
/**
 * fun incState() {
 * state = ConterEntity(state.number+1)
 * state = state.copy(state.number+1)
 * }
 *
 *
 * */
// fun View (CounterEntity) -> counter