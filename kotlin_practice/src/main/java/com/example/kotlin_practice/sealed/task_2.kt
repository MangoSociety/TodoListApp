package com.example.kotlin_practice.sealed

sealed class Expr
class Const(val number: Double) : Expr()
class Sum(val e1: Expr, val e2: Expr) : Expr()
// TODO: Добавьте класс для умножения

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    // TODO: Обработайте умножение
}