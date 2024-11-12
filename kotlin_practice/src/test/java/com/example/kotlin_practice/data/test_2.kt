package com.example.kotlin_practice.data

import kotlin.test.Test
import kotlin.test.assertEquals

class Test2 {

    @Test
    fun `success equals by x`() {
        val p1 = Point(1, 2)
        val p2 = Point(1, 3)
        assertEquals(
            actual = p1 == p2,
            expected = true
        )
    }

    @Test
    fun `unsuccess equals by x`() {
        val p2 = Point(1, 3)
        val p3 = Point(2, 4)
        assertEquals(
            actual = p2 == p3,
            expected = false
        )
    }

    @Test
    fun `point vs no point`() {
        val p1 = Point(1, 2)
        val p2 = 7
        assertEquals(
            actual = p1.equals(p2),
            expected = false
        )
    }

}