package com.example.kotlin_practice.exam.medium.delegate_ttl


interface Cache {
    fun get(key: String): Any?
    fun set(key: String, value: Any)
    fun remove(key: String)
}

// Задание:
// 1. Реализовать делегат свойств с поддержкой кэширования и валидации
// 2. Добавить возможность задавать время жизни кэша
// 3. Реализовать отложенную запись в кэш (write-back cache)
// 4. Поддержать weak references для очистки памяти

class CacheDelegate<T>(
    private val cache: Cache,
    private val key: String,
    private val validator: (T) -> Boolean = { true }
) {
    // Ваше решение
}