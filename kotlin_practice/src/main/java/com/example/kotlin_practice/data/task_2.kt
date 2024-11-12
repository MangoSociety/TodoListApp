package com.example.kotlin_practice.data

data class Point(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Point)
            return this.x == other.x
        return false
//        не совсем понятно, как и в какой момент мы принимаем для себя, что
//        this это p1, в other это p2. если это просто по ходу программы так,
//        как двигается компилятор по строкам кода сверзу вниз по полям, то ок,
//        в противном случае не ясно. может ли this быть p2? или other - это любое
//        другое значение, с которым идет сравнение в рамках выражения println(p1 == p2)?
    }
}

fun main() {
    val p1 = Point(1, 2)
    val p2 = Point(1, 3)
    val p3 = Point(2, 4)

    println(p1 == p2) // Должно вывести: true
    println(p2 == p3)
}