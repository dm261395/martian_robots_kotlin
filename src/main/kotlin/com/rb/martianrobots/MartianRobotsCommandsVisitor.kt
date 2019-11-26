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
        // Null safety checks for Java Platform Types
        ctx?.gridCoords()?.coordinates()?.let { coordinatesContext ->
            val x = coordinatesContext.xCoord()?.text?.toInt()
            val y = coordinatesContext.yCoord()?.text?.toInt()

            if (x != null && y != null) {
                grid = Grid(Coordinate(x, y))
                visitChildren(ctx)
            }
        }
    }

    override fun visitRobotConstructor(ctx: MartianRobotsCommandsParser.RobotConstructorContext?) {
        // Null safety checks for Java Platform Types
        ctx?.coordinates()?.let { coordinatesContext ->
            val x = coordinatesContext.xCoord()?.text?.toInt()
            val y = coordinatesContext.yCoord()?.text?.toInt()

            val orientationStr = ctx.ORIENTATION()?.text
            val orientation = if (orientationStr != null) Orientation.from(orientationStr) else null

            val instructions = ctx.INSTRUCTIONS()?.text?.map { Instruction.from(it.toString()) }

            grid?.let {
                if (x != null && y != null && orientation != null && instructions != null) {
                    robots.add(Robot(Coordinate(x, y), orientation, instructions, it))
                    visitChildren(ctx)
                }
            }
        }
    }
}