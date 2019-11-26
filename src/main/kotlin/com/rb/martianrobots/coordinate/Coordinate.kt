package com.rb.martianrobots.coordinate

import com.rb.martianrobots.constants.Instruction
import com.rb.martianrobots.constants.Orientation

class Coordinate(val x: Int, val y: Int) {
    fun computeNewCoordinates(
        orientation: Orientation,
        instruction: Instruction
    ): Coordinate {
        if (instruction == Instruction.FORWARD) {
            return when (orientation) {
                Orientation.NORTH -> Coordinate(
                    x,
                    y + 1
                )
                Orientation.EAST -> Coordinate(
                    x + 1,
                    y
                )
                Orientation.SOUTH -> Coordinate(
                    x,
                    y - 1
                )
                Orientation.WEST -> Coordinate(
                    x - 1,
                    y
                )
            }
        }
        return this
    }

    override fun toString() = "$x $y"
}

