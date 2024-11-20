package com.example.kotlin_practice.exam.medium

@Target(AnnotationTarget.CLASS)
annotation class Serializable

@Target(AnnotationTarget.PROPERTY)
annotation class SerialName(val name: String)

// Задание:
// - Создать систему сериализации на основе рефлексии
// - Поддержать вложенные объекты
// - Добавить кастомные сериализаторы
// - Реализовать валидацию на этапе компиляции