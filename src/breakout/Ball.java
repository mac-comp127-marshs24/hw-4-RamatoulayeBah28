package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;

import java.awt.Color;

public class Ball extends Ellipse{

    public static final double BALL_RADIUS = 10;
    public double speed, velocityX, velocityY;

    private GraphicsObject objectHit;

    public Ball(double x, double y, double speed) {

        // Creates an Ellipse with a specified width and height based on the radius of the ball
        super(x, y, 2 * BALL_RADIUS, 2 * BALL_RADIUS); 
        this.setFillColor(Color.black);

        // Adjust the initial velocity based on the speed
        velocityX = speed * 0.3; 
        velocityY = speed * 0.3; 
      
    }

    // Check the four corner points on the square in which the ball is inscribed
    public double getCenterX(){
        return getX() + BALL_RADIUS;
    }

    public double getCenterY(){
        return getY() + BALL_RADIUS;
    }

    public double getRightX(){
        return getX() + 2 * BALL_RADIUS;
    }

    public double getBottomY(){
        return getY() + 2 * BALL_RADIUS;
    }

    // Moves the ball on the canvas
    public void move(CanvasWindow canvas){

        if (getX() < 0){
            velocityX = -velocityX;
        }

        if (getRightX() > canvas.getWidth()){ 
            velocityX = -velocityX;
        }

        if (getY() < 0){
            velocityY = -velocityY;
        }

        moveBy(velocityX, velocityY);
        checkCollision(canvas);

    }

    public boolean checkBallPosition(CanvasWindow canvas){
        if (getY() > canvas.getHeight() - 10){

            return false;
        }
        else{

            return true;
        }
    }

    // Returns true if the ball has hit an object and if it's a brick, it destroys it. 
    private boolean testHit(CanvasWindow canvas, double x, double y) {

        objectHit = canvas.getElementAt(x, y);

        if (objectHit != null && !(objectHit instanceof GraphicsText)){

            if (objectHit instanceof Brick) {

                canvas.remove(objectHit);
                Brick brick = (Brick)objectHit;
                brick.setDestroyed();
            }
            return true;
        }
        return false;
    }

    // Check if something has touched the different sides of the ball and if yes, bounce back
    private void checkCollision(CanvasWindow canvas){

        if (testHit(canvas, getX() + BALL_RADIUS, getY() - 1)){ 
            velocityY = -velocityY;
        }
        
        if(testHit(canvas, getX() + BALL_RADIUS, getY() + 2 * BALL_RADIUS + 1)){ 
            velocityY = -velocityY;
        }

        if(testHit(canvas, getX() - 1 , getY() + BALL_RADIUS)){
            velocityX = -velocityX;
        }

        if(testHit(canvas, getX() + 2 * BALL_RADIUS + 1 , getY() + BALL_RADIUS)){ 
            velocityX = -velocityX;
        }
    }

}