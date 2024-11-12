package com.example.kotlin_practice.sealed

sealed class Expr
class Const(val number: Double) : Expr()
class Sum(val e1: Expr, val e2: Expr) : Expr()
class Umn(val e1: Expr, val e2: Expr) : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    is Umn -> eval(expr.e1) * eval(expr.e2)
}

// umn (const=2, const=2) <- eval
// eval(expr.e1) -> eval(Const(2.0)) = 2.0
// eval(expr.e2) -> eval(Const(2.0)) = 2.0
// from first step = umn (const=2, const=2) => 2.0 * 2.0

// umn (const=2, Sum(Const(3.0), Const(4.0))) <- eval
// eval(expr.e1) -> eval(Const(2.0)) = 2.0
// eval(expr.e2) -> eval(Sum(Const(3.0), Const(4.0))) = eval(3.0) eval (4.0)
// from first step = umn (const=2, Sum(Const(3.0), Const(4.0))) => 2.0 * ( 3.0 + 4.0 )