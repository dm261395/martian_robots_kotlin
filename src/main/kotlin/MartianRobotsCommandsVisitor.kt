import com.exercises.martianrobots.coordinate.Coordinate
import com.exercises.martianrobots.grid.Grid
import com.exercises.martianrobots.robot.Robot

class MartianRobotsCommandsVisitor : MartianRobotsGrammarBaseVisitor<Unit>() {
    var grid: Grid? = null
    val robots: List<Robot> = listOf()

    override fun visitInput(ctx: MartianRobotsGrammarParser.InputContext?) {
        if (ctx != null) {
            val x = ctx.gridCoords()?.coordinates()?.xCoord()?.text?.toInt();
            val y = ctx.gridCoords()?.coordinates()?.yCoord()?.text?.toInt();
            if (x != null && y != null) {
                grid = Grid(Coordinate(x, y))
            }
        }
    }
}