package com.exercises.martianrobots.coordinate

data class Coordinate(val x: Int, val y: Int) {
    operator fun compareTo(other: Coordinate): Int = (other.x + other.y) - (x + y)

    override fun toString(): String = "$x $y"
}

