package com.example.kotlin_practice.exam.easy.data_class

// Реализовать версионированный объект
data class Versioned<T>(
    val value: T,
    val version: Long = 0
)

class VersionControl<T> {
    private val versions = mutableListOf<Versioned<T>>()
    private var versionCounter: Long = 0

    fun saveVersion(value: T) {
        val newVersion = Versioned(value, versionCounter)
        versions.add(newVersion)
        versionCounter++
    }

    fun getAllVersions(): List<Versioned<T>> {
        return versions.toList()
    }

    fun getDirectlyVersion(versionIndex: Int): Versioned<T>? {
        return versions.getOrNull(versionIndex)
    }

    fun mergeVersion(
        version1: Versioned<T>,
        version2: Versioned<T>,
        mergeFunction: (T, T) -> T
    ): Versioned<T> {
        val mergedValue = mergeFunction(version1.value, version2.value)
        val mergedVersion = Versioned(mergedValue, versionCounter)
        versions.add(mergedVersion)
        versionCounter++
        return mergedVersion
    }
}

fun main() {
    val exam = VersionControl<String>()

    exam.saveVersion("Ver1")
    exam.saveVersion("Ver2")
    exam.saveVersion("Ver3")
    exam.saveVersion("Ver4")


    println(exam.getAllVersions())

    exam.getDirectlyVersion(3)
    println(exam.getDirectlyVersion(3))

    val version1 = exam.getDirectlyVersion(2)!!
    val version2 = exam.getDirectlyVersion(0)!!
    val merging = exam.mergeVersion(version1, version2) { v1, v2 -> "&v1 &v2" }

    println("Объединенная версия: $merging")
    println("Все версии: ${exam.getAllVersions()}")
}


// Реализовать:
// 1. Методы для обновления значения с увеличением версии
// 2. Историю изменений
// 3. Возможность отката к предыдущей версии
// 4. Слияние версий при параллельном изменении
