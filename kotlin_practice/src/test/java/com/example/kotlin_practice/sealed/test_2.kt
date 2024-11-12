package com.example.kotlin_practice.sealed

import kotlin.test.Test
import kotlin.test.assertEquals

class Test2 {

    @Test
    fun `success`() {
        val umn = eval(
            Umn(
                Const(2.0),
                Sum(
                    Const(3.0),
                    Const(4.0)
                )
            )
        )
        assertEquals(
            expected = umn,
            actual = 14.0
        )
    }

}