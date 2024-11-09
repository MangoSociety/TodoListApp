package com.example.kotlin_practice.sealed

// TODO: Определите классы Rectangle (с шириной и высотой) и Triangle (с основанием и высотой), наследующие от Shape.

sealed class Shape

class Circle(val radius: Double) : Shape()

// TODO: Добавьте классы Rectangle и Triangle, наследующие от Shape