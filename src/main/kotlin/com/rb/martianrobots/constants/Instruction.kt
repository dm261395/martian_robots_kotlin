package com.rb.martianrobots.constants

enum class Instruction(val value: String) {
    LEFT("L"), RIGHT("R"), FORWARD("F");

    override fun toString() = value

    companion object {
        fun from(instructionStr: String) = values().first { it.value == instructionStr }
    }
}