package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import java.awt.Color;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    public static final double BALL_RADIUS = 5;

    private CanvasWindow canvas;
    private BrickManager brickWall;
    private Ball ball;
    private Paddle paddle;

    private int lives = 3;
    private GraphicsText livesText, loseText, winText;


    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        brickWall = new BrickManager(canvas);

        livesText = new GraphicsText("Lives: " + lives);
        livesText.setPosition(10, 20);
        livesText.setFont(FontStyle.BOLD, 18);
        canvas.add(livesText);
        
        ball = new Ball(300, 400, 15); 
        paddle = new Paddle(250, 700, 120, 10);
        canvas.add(ball);
        canvas.add(paddle);
        canvas.draw();
        canvas.pause(3000);

        // Move the paddle with the mouse mouvement
        canvas.onMouseMove(event -> paddle.setPosition(event.getPosition().getX(),700));
        canvas.draw();

        // Animate the ball and manage the game conditions
        canvas.animate(() -> {
            ball.move(canvas); 
            canvas.draw();
            if (!ball.checkBallPosition(canvas)){
                lives--;
                livesText.setText("Lives: " + lives);
                canvas.remove(ball);
                ball = new Ball(300, 400, 15);
                canvas.add(ball);
                canvas.remove(paddle);
                paddle = new Paddle(250, 700, 120, 10);
                canvas.add(paddle);
                canvas.draw();
                canvas.pause(3000);
            }
            if (lives == 0){
                lose();
            }
            if (!brickWall.bricksStillExist()){
                win();
            }
        });
       
    }

    public void win(){
        winText = new GraphicsText("YOU WON!");
        winText.setPosition(CANVAS_WIDTH / 2 - winText.getWidth() - 60, CANVAS_HEIGHT / 2 - 50);
        winText.setFont(FontStyle.BOLD, 48);
        winText.setFillColor(Color.GREEN);
        canvas.add(winText);
        canvas.draw();
        canvas.pause(2000);
        canvas.removeAll();
        canvas.closeWindow();
    }

    public void lose(){
        loseText  = new GraphicsText("GAME OVER");
        loseText.setPosition(CANVAS_WIDTH / 2 - loseText.getWidth() - 60, CANVAS_HEIGHT / 2 - 50);
        loseText.setFont(FontStyle.BOLD, 48);
        loseText.setFillColor(Color.RED);
        canvas.add(loseText);
        canvas.draw();
        canvas.pause(2000);
        canvas.removeAll();
        canvas.closeWindow();
    }

    public static void main(String[] args){
        new BreakoutGame();
    }
}
