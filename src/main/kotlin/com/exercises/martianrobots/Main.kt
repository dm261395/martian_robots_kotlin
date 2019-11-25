package com.exercises.martianrobots

import MartianRobotsCommandsVisitor
import MartianRobotsGrammarLexer
import MartianRobotsGrammarParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
    val lexer = MartianRobotsGrammarLexer(CharStreams.fromFileName("input.txt"))
    val tokens = CommonTokenStream(lexer)
    val parser = MartianRobotsGrammarParser(tokens)
    val tree = parser.input()
    MartianRobotsCommandsVisitor().visit(tree)
}

