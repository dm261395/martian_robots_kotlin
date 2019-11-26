package com.rb.martianrobots.utils

import com.rb.martianrobots.constants.Instruction
import com.rb.martianrobots.constants.Orientation
import com.rb.martianrobots.coordinate.Coordinate

class Utils {
    companion object CoordinateUtils {
        fun getNewCoordinates(
            coords: Coordinate,
            orientation: Orientation,
            instruction: Instruction
        ): Coordinate {
            if (instruction == Instruction.FORWARD) {
                return when (orientation) {
                    Orientation.NORTH -> Coordinate(
                        coords.x,
                        coords.y + 1
                    )
                    Orientation.EAST -> Coordinate(
                        coords.x + 1,
                        coords.y
                    )
                    Orientation.SOUTH -> Coordinate(
                        coords.x,
                        coords.y - 1
                    )
                    Orientation.WEST -> Coordinate(
                        coords.x - 1,
                        coords.y
                    )
                }
            }
            return coords
        }
    }
}