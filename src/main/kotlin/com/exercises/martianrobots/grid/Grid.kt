package com.exercises.martianrobots.grid

import com.exercises.martianrobots.coordinate.Coordinate

class Grid(private val topRightCoords: Coordinate) {
    private var scentsCoords: MutableList<Coordinate> = mutableListOf<Coordinate>()
    private val bottomLeftCoords: Coordinate = Coordinate(0, 0)

    fun hasScentAtCoordinates(coords: Coordinate): Boolean =
        scentsCoords.find { it.equals(coords) } != null

    fun coordinatesAreInBounds(coords: Coordinate): Boolean = bottomLeftCoords <= coords && coords <= topRightCoords

    fun addScentCoordinates(coords: Coordinate) {
        if (coordinatesAreInBounds(coords)) {
            scentsCoords.add(coords)
        }
    }
}