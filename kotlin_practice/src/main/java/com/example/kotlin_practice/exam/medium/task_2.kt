package com.example.kotlin_practice.exam.medium

import java.util.concurrent.locks.Condition

data class Query(
    val select: List<String>,
    val from: String,
    val where: List<Condition>,
    val orderBy: List<String>
)

// Задание:
// Создать type-safe DSL для построения SQL-подобных запросов:
/* Пример использования:
query {
    select("name", "age")
    from("users")
    where {
        "age" greaterThan 18
        "name" like "John%"
    }
    orderBy("name").desc()
}
*/