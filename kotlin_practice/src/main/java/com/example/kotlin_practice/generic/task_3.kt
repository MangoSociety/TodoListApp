package com.example.kotlin_practice.generic

class Repository {
    val data = mutableMapOf<String, Any>()

    // TODO: Реализуйте обобщенный метод save
    fun <T> save(key: String, value: T) {
        data[key] = value as Any
    }

    // TODO: Реализуйте обобщенный метод get
    inline fun <reified T> get(key: String): T? {
        return data[key] as? T

    }
}

fun main() {
    val repo = Repository()
    repo.save("user1", User("Alice"))
    val user: User? = repo.get("user1")

    println(user) // Ожидаемый вывод: User(name=Alice)
}

data class User(val name: String)