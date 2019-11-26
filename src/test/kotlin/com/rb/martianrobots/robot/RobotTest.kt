package com.rb.martianrobots.robot

import com.rb.martianrobots.constants.Instruction
import com.rb.martianrobots.constants.Orientation
import com.rb.martianrobots.coordinate.Coordinate
import com.rb.martianrobots.grid.Grid
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RobotTest {
    @Test
    fun robot_NavigatesGridCorrectly_ForOneRobot() {
        val grid = Grid(
            Coordinate(
                5,
                3
            )
        )
        val instructions = listOf<Instruction>(
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.FORWARD
        )
        val robot = Robot(
            Coordinate(
                1,
                1
            ), Orientation.EAST, instructions, grid
        )
        robot.applyInstructions()

        assertEquals(Orientation.EAST, robot.orientation)
        assertEquals(1, robot.coords.x)
        assertEquals(1, robot.coords.y)
        assertFalse(robot.isLost)
    }

    @Test
    fun robot_NavigatesGridCorrectly_ForMultipleRobots() {
        val grid = Grid(
            Coordinate(
                5,
                3
            )
        )

        val instructions1 = listOf<Instruction>(
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.FORWARD
        )

        val robot1 = Robot(
            Coordinate(
                1,
                1
            ), Orientation.EAST, instructions1, grid
        )

        val instructions2 = listOf<Instruction>(
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.LEFT,
            Instruction.LEFT,
            Instruction.FORWARD,
            Instruction.FORWARD,
            Instruction.RIGHT,
            Instruction.RIGHT,
            Instruction.FORWARD,
            Instruction.LEFT,
            Instruction.LEFT
        )

        val robot2 = Robot(
            Coordinate(
                3,
                2
            ), Orientation.NORTH, instructions2, grid
        )

        val instructions3 = listOf<Instruction>(
            Instruction.LEFT,
            Instruction.LEFT,
            Instruction.FORWARD,
            Instruction.FORWARD,
            Instruction.FORWARD,
            Instruction.LEFT,
            Instruction.FORWARD,
            Instruction.LEFT,
            Instruction.FORWARD,
            Instruction.LEFT
        )

        val robot3 = Robot(
            Coordinate(
                0,
                3
            ), Orientation.WEST, instructions3, grid
        )

        robot1.applyInstructions()
        robot2.applyInstructions()
        robot3.applyInstructions()

        assertEquals(Orientation.EAST, robot1.orientation)
        assertEquals(1, robot1.coords.x)
        assertEquals(1, robot1.coords.y)
        assertFalse(robot1.isLost)

        assertEquals(Orientation.NORTH, robot2.orientation)
        assertEquals(3, robot2.coords.x)
        assertEquals(3, robot2.coords.y)
        assertTrue(robot2.isLost)

        assertEquals(Orientation.SOUTH, robot3.orientation)
        assertEquals(2, robot3.coords.x)
        assertEquals(3, robot3.coords.y)
        assertFalse(robot3.isLost)
    }

    @Test
    fun robot_MovesOffGridAndGetsLost() {
        val grid = Grid(
            Coordinate(
                5,
                3
            )
        )
        val instructions = listOf<Instruction>(
            Instruction.FORWARD
        )
        val robot = Robot(
            Coordinate(
                5,
                3
            ), Orientation.NORTH, instructions, grid
        )
        robot.applyInstructions()

        assertEquals(5, robot.coords.x)
        assertEquals(4, robot.coords.y)
        assertTrue(robot.isLost)
    }
}