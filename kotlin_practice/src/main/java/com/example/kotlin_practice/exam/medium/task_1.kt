package com.example.kotlin_practice.exam.medium

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()
}

// Задание:
// - Реализовать map, flatMap, fold для Either
// - Добавить функции для композиции нескольких Either
// - Реализовать монадические операции
// - Создать DSL для обработки ошибок с Either