package com.example.kotlin_practice.exam.easy.delegate

import kotlin.reflect.KProperty

// Реализовать делегат для валидации свойств
class ValidationDelegate<T>(
    private val validator: (T) -> Boolean,
    private val onInvalid: (T) -> Unit
) {
    // ваш код


    // Реализовать делегат, который:
    // 1. Проверяет значение перед присваиванием
    // 2. Вызывает onInvalid если значение некорректно
    // 3. Кэширует последнее валидное значение
    // 4. Выбрасывает исключение при попытке установить невалидное значение
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        // ваш код
        return -1
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        // ваш код
    }
}

// Пример использования:
class User {
    var age: Int by ValidationDelegate<Int>(
        validator = {
            return@ValidationDelegate it in 0..150
        },
        onInvalid = {
            println("Invalid age: $it")
        })
}