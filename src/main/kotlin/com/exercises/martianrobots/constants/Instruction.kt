package com.exercises.martianrobots.constants

enum class Instruction(val value: String) {
    LEFT("L"), RIGHT("R"), FORWARD("F");

    companion object {
        fun from(instructionStr: String): Instruction = values().first() { it.value == instructionStr }
    }
}