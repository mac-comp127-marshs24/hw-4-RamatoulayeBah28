package breakout;

import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.ui.Button;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private CanvasWindow canvas;

    // private static boolean animating;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        // List<Brick> brickWall = List.of(new Brick(canvas), new Brick(canvas), new Brick(canvas));
    
        Paddle paddle = new Paddle(canvas);
        Ball ball = new Ball(canvas);
        BrickManager brick = new BrickManager(canvas);
        
       
    }

    public static void main(String[] args){
        new BreakoutGame();
        
    }
}
