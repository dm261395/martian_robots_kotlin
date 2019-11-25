package com.exercises.martianrobots.constants

enum class Instruction(val value: String) {
    LEFT("L"), RIGHT("R"), FORWARD("F");

    override fun toString(): String = value

    companion object {
        fun from(instructionStr: String): Instruction = values().first() { it.value == instructionStr }
    }
}