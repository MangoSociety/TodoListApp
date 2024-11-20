package com.example.kotlin_practice.exam.easy

import java.math.BigDecimal
import java.time.Instant

data class Transaction(
    val id: String,
    val amount: BigDecimal,
    val type: String,
    val timestamp: Instant
)

// Задание:
// - Реализовать обработку большого списка транзакций (1млн+ элементов)
// - Сгруппировать по типу, посчитать суммы
// - Сравнить производительность при использовании Sequence vs Collection
// - Реализовать свой кастомный итератор

class TransactionProcessor {
    fun process(transactions: List<Transaction>) {
        // Ваш код здесь
    }
}