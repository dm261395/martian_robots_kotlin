package com.exercises.martianrobots.grid

import com.exercises.martianrobots.coordinate.Coordinate

class Grid(private val topRightCoords: Coordinate) {
    private var scentsCoords: MutableList<Coordinate> = mutableListOf()
    private val bottomLeftCoords: Coordinate = Coordinate(0, 0)

    fun hasScentAtCoordinates(coords: Coordinate): Boolean = scentsCoords.find { it.equals(coords) } != null

    fun coordinatesAreInBounds(coords: Coordinate): Boolean =
        bottomLeftCoords.x <= coords.x && coords.x <= topRightCoords.x && bottomLeftCoords.y <= coords.y && coords.y <= topRightCoords.y

    fun addScentCoordinates(coords: Coordinate) {
        if (coordinatesAreInBounds(coords)) {
            scentsCoords.add(coords)
        }
    }
}