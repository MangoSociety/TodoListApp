package com.example.kotlin_practice.exam.medium

import java.math.BigDecimal

data class Order(
    val id: Long,
    val items: List<Item>,
    val status: Status
)

data class Item(
    val name: String,
    val price: BigDecimal,
    val quantity: Int
)

enum class Status { NEW, PROCESSING, COMPLETED, CANCELLED }

// Задание:
// 1. Сгруппировать заказы по статусу
// 2. Для каждого статуса посчитать общую сумму заказов
// 3. Найти топ-3 самых популярных товаров (по количеству)
// 4. Реализовать как с помощью Collection API, так и с Sequence для сравнения производительности

class OrderAnalytics {
    fun analyzeOrders(orders: List<Order>) {
        // Ваше решение
    }
}