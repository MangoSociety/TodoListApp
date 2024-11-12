package com.example.kotlin_practice.data

/**
 * success equals by x
 * point vs no point
 * */
data class Point(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Point)
            return this.x == other.x
        return false
    }
}

fun main() {
    val p1 = Point(1, 2)
    val p2 = Point(1, 3)
    val p3 = Point(2, 4)

    // p1 == p2
    // p1.equals(p2)

    // p2 == p1
    println(p1 == p2) // Должно вывести: true
    println(p2 == p3)
}