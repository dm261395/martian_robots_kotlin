package com.rb.martianrobots

import MartianRobotsCommandsBaseVisitor
import MartianRobotsCommandsParser
import com.rb.martianrobots.constants.Instruction
import com.rb.martianrobots.constants.Orientation
import com.rb.martianrobots.coordinate.Coordinate
import com.rb.martianrobots.grid.Grid
import com.rb.martianrobots.robot.Robot

class MartianRobotsCommandsVisitor : MartianRobotsCommandsBaseVisitor<Unit>() {
    var grid: Grid? = null
    val robots: MutableList<Robot> = mutableListOf()

    override fun visitInput(ctx: MartianRobotsCommandsParser.InputContext?) {
        val coordinatesCtx = ctx?.gridCoords()?.coordinates()

        if (coordinatesCtx != null) {
            val x = coordinatesCtx.xCoord().text.toInt()
            val y = coordinatesCtx.yCoord().text.toInt()
            grid = Grid(Coordinate(x, y))
        }
        visitChildren(ctx)
    }

    override fun visitRobotConstructor(ctx: MartianRobotsCommandsParser.RobotConstructorContext?) {
        val coordinatesCtx = ctx?.coordinates()

        if (grid != null && coordinatesCtx != null && ctx.orientation() != null) {
            val x = coordinatesCtx.xCoord().text.toInt()
            val y = coordinatesCtx.yCoord().text.toInt()
            val orientation = Orientation.from(ctx.orientation().text)
            val instructions = ctx.INSTRUCTIONS().text.map { Instruction.from(it.toString()) }
            grid?.let {
                robots.add(Robot(Coordinate(x, y), orientation, instructions, it))
            }
        }
        visitChildren(ctx)
    }
}