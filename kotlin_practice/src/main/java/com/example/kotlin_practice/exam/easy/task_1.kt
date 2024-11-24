package com.example.kotlin_practice.exam.easy

import java.math.BigDecimal
import java.time.Instant
import kotlin.system.measureTimeMillis

data class Transaction (
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
        val listTime = measureTimeMillis {
            val groupedTransactions = transactions
                .groupBy { it.type }
            val sumOfAmount = groupedTransactions
                .mapValues { (_, amountList) ->
                amountList.sumOf { it.amount }
            }
            println("Сгруппированные и просуммированные транзакци: $sumOfAmount")
        }
        println("Время обработки List: $listTime")

        //Использование сиквенс
        val sequenceTime = measureTimeMillis {
            val sequenceTransaction = transactions
                .asSequence()
                .groupBy { it.type }
                .mapValues { (_, amountList) -> amountList.sumOf { it.amount } }
            println("Использование Sequence: $sequenceTransaction")
        }
        println("Время обработки Sequence:$sequenceTime")
    }
}

    fun main() {
        val ex = listOf(
            Transaction("1", BigDecimal("12.1"), "trans", timestamp = Instant.now()),
            Transaction("2", BigDecimal("12424.1"), "change", timestamp = Instant.now()),
            Transaction("3", BigDecimal("56731.1"), "trans", timestamp = Instant.now()),
            Transaction("4", BigDecimal("12.1"), "change", timestamp = Instant.now())
        )
        val statrOperation = TransactionProcessor().process(ex)
    }

