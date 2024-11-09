package com.example.kotlin_practice.generic

class Repository {
    private val data = mutableMapOf<String, Any>()

    // TODO: Реализуйте обобщенный метод save

    // TODO: Реализуйте обобщенный метод get
}

fun main() {
//    val repo = Repository()
//    repo.save("user1", User("Alice"))
//    val user: User? = repo.get("user1")
//
//    println(user) // Ожидаемый вывод: User(name=Alice)
}

data class User(val name: String)