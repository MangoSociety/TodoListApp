package com.example.kotlin_practice.sealed

// TODO: Определите классы Rectangle (с шириной и высотой) и Triangle (с основанием и высотой), наследующие от Shape.

sealed class Shape

class Circle(val radius: Double) : Shape()
class Rectangle(val bR: Double, val hR: Double):Shape()
class Triangle( val bT: Double, val hT: Double): Shape()

// TODO: Добавьте классы Rectangle и Triangle, наследующие от Shape