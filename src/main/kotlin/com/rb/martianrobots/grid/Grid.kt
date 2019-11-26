package com.rb.martianrobots.grid

import com.rb.martianrobots.coordinate.Coordinate

class Grid(private val topRightCoords: Coordinate) {
    private var scentsCoords: MutableList<Coordinate> = mutableListOf()
    private val bottomLeftCoords: Coordinate =
        Coordinate(0, 0)

    fun hasScentAtCoordinates(coords: Coordinate) = scentsCoords.any { it == coords }

    fun coordinatesAreInBounds(coords: Coordinate) =
        bottomLeftCoords.x <= coords.x && coords.x <= topRightCoords.x && bottomLeftCoords.y <= coords.y && coords.y <= topRightCoords.y

    fun addScentCoordinates(coords: Coordinate) {
        if (coordinatesAreInBounds(coords)) {
            scentsCoords.add(coords)
        }
    }
}