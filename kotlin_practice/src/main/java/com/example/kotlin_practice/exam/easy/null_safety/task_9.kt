package com.example.kotlin_practice.exam.easy.null_safety

// Задача 2: Реализовать коллекцию с null-safe операциями
class SafeList<T> {
    private val items = mutableListOf<T?>()

    // Реализовать методы, которые безопасно обрабатывают null элементы:
    // 1. addIfNotNull: добавляет элемент только если он не null
    // 2. filterNotNull: возвращает новый SafeList без null элементов
    // 3. mapNotNull: преобразует элементы, пропуская null
    // 4. firstOrNull: возвращает первый не-null элемент или null

    // Методы должны поддерживать chain-операции
}