package com.example.kotlin_practice.exam.easy.null_safety

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

    // 2. filterNotNull: возвращает новый SafeList без null элементов
    fun filterNotNull(): SafeList<T> {
        val notNullItem = items.filterNotNull()
        val notNullSafeList = SafeList<T>()
        notNullItem.forEach { notNullSafeList.addIfNotNull(it) }
        return notNullSafeList
    }

    // 3. mapNotNull: преобразует элементы, пропуская null
    fun <R : Any> mapNotNull(transform: (T?) -> R?): SafeList<R> {
        val mappedItem = items.mapNotNull(transform)
        val resultSafeList = SafeList<R>()
        mappedItem.forEach { resultSafeList.addIfNotNull(it) }
        return resultSafeList


    }

    override fun toString(): String {
        return items.toString()
    }


    // 4. firstOrNull: возвращает первый не-null элемент или null

    // Методы должны поддерживать chain-операции
}

fun main() {
    val safeList = SafeList<String>()

    safeList
        .addIfNotNull("robert")
        .addIfNotNull("foruh")
        .addIfNotNull("pipin")
        .addIfNotNull(null)
        .addIfNotNull("goldy")

    println(safeList.toString())

    val filtredList = safeList.filterNotNull()
    println(filtredList)

    val filterdListByMap = safeList.mapNotNull { it?.length }
}