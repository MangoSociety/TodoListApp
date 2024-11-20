package com.example.kotlin_practice.exam.easy.sealed

// Реализовать конечный автомат для управления заказом
sealed class OrderState {
    object Created : OrderState()
    data class Processing(val startTime: Long) : OrderState()
    data class Shipped(val trackingNumber: String) : OrderState()
    data class Delivered(val deliveryTime: Long) : OrderState()
    data class Cancelled(val reason: String) : OrderState()
}

class OrderStateMachine {
    // Реализовать:
    // 1. Методы для перехода между состояниями
    // 2. Валидацию возможных переходов
    // 3. История переходов
    // 4. Откат к предыдущему состоянию
}