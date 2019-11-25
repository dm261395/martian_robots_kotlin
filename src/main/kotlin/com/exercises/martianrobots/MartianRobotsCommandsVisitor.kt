package com.exercises.martianrobots

import MartianRobotsGrammarBaseVisitor
import MartianRobotsGrammarParser
import com.exercises.martianrobots.constants.Instruction
import com.exercises.martianrobots.constants.Orientation
import com.exercises.martianrobots.coordinate.Coordinate
import com.exercises.martianrobots.grid.Grid
import com.exercises.martianrobots.robot.Robot

class MartianRobotsCommandsVisitor : MartianRobotsGrammarBaseVisitor<Unit>() {
    var grid: Grid? = null
    val robots: MutableList<Robot> = mutableListOf()

    override fun visitInput(ctx: MartianRobotsGrammarParser.InputContext?) {
        val coordinatesCtx = ctx?.gridCoords()?.coordinates()
        
        if (coordinatesCtx != null) {
            val x = coordinatesCtx.xCoord().text.toInt()
            val y = coordinatesCtx.yCoord().text.toInt()
            grid = Grid(Coordinate(x, y))
        }
        visitChildren(ctx)
    }

    override fun visitRobotConstructor(ctx: MartianRobotsGrammarParser.RobotConstructorContext?) {
        val coordinatesCtx = ctx?.coordinates()

        if (grid != null && coordinatesCtx != null && ctx.orientation() != null) {
            val x = coordinatesCtx.xCoord().text.toInt()
            val y = coordinatesCtx.yCoord().text.toInt()
            val orientation = Orientation.from(ctx.orientation().text)
            val instructions = ctx.INSTRUCTIONS().text.map { Instruction.from(it.toString()) }
            robots.add(Robot(Coordinate(x, y), orientation, instructions, grid!!))
        }
        visitChildren(ctx)
    }
}