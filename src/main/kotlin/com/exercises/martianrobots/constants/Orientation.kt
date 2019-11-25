package com.exercises.martianrobots.constants

enum class Orientation(val value: String) {
    NORTH("N") {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                Instruction.LEFT -> WEST
                Instruction.RIGHT -> EAST
                else -> this
            }
        }
    },
    EAST("E") {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                Instruction.LEFT -> NORTH
                Instruction.RIGHT -> SOUTH
                else -> this
            }
        }
    },
    SOUTH("S") {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                Instruction.LEFT -> EAST
                Instruction.RIGHT -> WEST
                else -> this
            }
        }
    },
    WEST("W") {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                Instruction.LEFT -> SOUTH
                Instruction.RIGHT -> NORTH
                else -> this
            }
        }
    };

    override fun toString(): String = value

    companion object {
        fun from(orientationStr: String): Orientation = values().first { it.value == orientationStr }
    }

    abstract fun getNewOrientation(instruction: Instruction): Orientation
}