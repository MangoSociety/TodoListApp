package com.example.kotlin_practice.exam.easy.null_safety

import com.example.kotlin_practice.R

// Задача 2: Реализовать коллекцию с null-safe операциями
class SafeList<T> {
    private val items = mutableListOf<T?>()

    // Реализовать методы, которые безопасно обрабатывают null элементы:
    // 1. addIfNotNull: добавляет элемент только если он не null
    fun addIfNotNull(newItem: T?): SafeList<T> {
        if (newItem !== null) {
            items.add(newItem)
        }
        return this
    }

    fun toList(): List<T?> {
        return items.toList()
    }

    // 2. filterNotNull: возвращает новый SafeList без null элементов
//    fun filterNotNull(): SafeList<T> {
//        val notNullItem = items.filterNotNull()
//        val notNullSafeList = SafeList<T>()
//        notNullItem.forEach { notNullSafeList.addIfNotNull(it) }
//        return notNullSafeList
//    }
//
//    // 3. mapNotNull: преобразует элементы, пропуская null
//    fun <R : Any> mapNotNull(transform: (T?) -> R?): SafeList<R> {
//        val resultSafeList = SafeList<R>()
//        items.forEach { item ->
//            item?.let {
//                val transformed = transform(it)
//                transformed?.let { resultSafeList.addIfNotNull(transformed) }
//            }
//        }
//        return resultSafeList
//    }
//    // 4. firstOrNull: возвращает первый не-null элемент или null
//
//    fun firstOrNull(): T? {
//        for (item in items) {
//            if (item != null) {
//                return item
//            }
//        }
//        return null
//    }

    override fun toString(): String {
        return items.toString()
    }
    // Методы должны поддерживать chain-операции
}

fun main() {
    val safeList = SafeList<String>()

    safeList
        .addIfNotNull("hebrfnmmf")
        .addIfNotNull("foruh")
        .addIfNotNull("pipin")
        .addIfNotNull(null)
        .addIfNotNull("goldy")

    println(safeList.toString())

    val lenghtList = safeList.filterNotNullAndMap { it.length }
    val uppercaseList = safeList.filterNotNullAndMap { it.uppercase() }
    println(lenghtList)
    println(uppercaseList)

    val firstItem = safeList.firstOrNull()
    println(firstItem)
}