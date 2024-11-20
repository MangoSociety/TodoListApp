package com.example.kotlin_practice.exam.medium

data class FilterCondition(
    val field: String,
    val operator: String,
    val value: Any
)

// Задание: Создать DSL для построения запросов с поддержкой:
// 1. Вложенных условий (AND, OR)
// 2. Различных операторов сравнения
// 3. Типобезопасности для значений полей
// 4. Валидации на этапе компиляции

/* Пример желаемого использования:
query {
    select("name", "age")
    from("users")
    where {
        "age" greaterThan 18
        or {
            "name" contains "John"
            "email" endsWith "@gmail.com"
        }
    }
    orderBy("name")
}
*/