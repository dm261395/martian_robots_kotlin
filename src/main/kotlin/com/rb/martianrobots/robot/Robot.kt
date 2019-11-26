package com.rb.martianrobots.robot

import com.rb.martianrobots.constants.Instruction
import com.rb.martianrobots.constants.Orientation
import com.rb.martianrobots.coordinate.Coordinate
import com.rb.martianrobots.grid.Grid
import com.rb.martianrobots.utils.Utils

class Robot(
    initialCoords: Coordinate,
    initialOrientation: Orientation,
    val instructions: List<Instruction>,
    val grid: Grid
) {
    var coords = initialCoords
    var orientation = initialOrientation
    var isLost = false

    fun getRobotMessage() = "$coords $orientation ${if (isLost) "LOST" else ""}"

    fun applyInstructions() {
        for (instruction in instructions) {
            orientation = orientation.getNewOrientation(instruction)
            val newCoords = Utils.getNewCoordinates(coords, orientation, instruction)

            val newCoordsAreInBounds = grid.coordinatesAreInBounds(newCoords)
            val currentCoordsHaveScent = grid.hasScentAtCoordinates(coords)

            if (newCoordsAreInBounds) {
                coords = newCoords
            } else if (!currentCoordsHaveScent) {
                // Check that robot is currently in the grid since it can only be lost if it moves from
                // within the grid to outside the grid.
                if (grid.coordinatesAreInBounds(coords)) {
                    // Robot moves off grid and is now lost. It leaves its scent behind.
                    isLost = true
                    grid.addScentCoordinates(coords)
                }
                coords = newCoords
            }
            // The new coords are out of bounds but there is a scent at current position - ignore instruction.
        }
    }
}