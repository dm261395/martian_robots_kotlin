package com.exercises.martianrobots.constants

enum class Orientation {
    NORTH {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                DirectionalInstruction.LEFT -> WEST
                DirectionalInstruction.RIGHT -> EAST
                else -> this
            }
        }
    },
    EAST {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                DirectionalInstruction.LEFT -> NORTH
                DirectionalInstruction.RIGHT -> SOUTH
                else -> this
            }
        }
    },
    SOUTH {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                DirectionalInstruction.LEFT -> EAST
                DirectionalInstruction.RIGHT -> WEST
                else -> this
            }
        }
    },
    WEST {
        override fun getNewOrientation(instruction: Instruction): Orientation {
            return when (instruction) {
                DirectionalInstruction.LEFT -> SOUTH
                DirectionalInstruction.RIGHT -> NORTH
                else -> this
            }
        }
    };

    abstract fun getNewOrientation(instruction: Instruction): Orientation
}