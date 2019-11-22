package com.exercises.martianrobots.constants

interface Instruction

enum class DirectionalInstruction : Instruction {
    LEFT, RIGHT
}

enum class MovementInstruction : Instruction {
    FORWARD
}