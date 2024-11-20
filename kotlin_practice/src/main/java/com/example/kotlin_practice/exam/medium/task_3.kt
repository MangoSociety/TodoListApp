package com.example.kotlin_practice.exam.medium

interface Cache<T> {
    fun get(key: String): T?
    fun set(key: String, value: T)
}

// Задание:
// - Реализовать делегат свойств с поддержкой кэширования
// - Добавить валидацию значений
// - Реализовать отложенную инициализацию
// - Создать делегат для thread-safe операций