package com.example.kotlin_practice.data

import kotlin.test.Test
import kotlin.test.assertEquals


class Test1 {

    @Test
    fun `Update age WHEN updateAge()`() {
        val person = updateAge(21)
        assertEquals(
            expected = 21,
            actual = person.age
        )
    }

}