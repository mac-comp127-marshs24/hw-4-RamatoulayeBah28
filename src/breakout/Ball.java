package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;

public class Ball extends GraphicsGroup{

    double posX = 250;
    double posY = 700;
    double width = 12;
    double height = 12;
    double speedX = 2; // Speed in X direction
    double speedY = 5; // Speed in Y direction

    private static boolean animating;

    public Ball(CanvasWindow canvas) {

        Ellipse ball = new Ellipse(posX, posY, width, height);
        ball.setFilled(true);
        ball.setFillColor(Color.BLACK);
        ball.setStroked(false);

        animating = true;

        canvas.animate(
            () ->
            {
            posX += speedX;
            posY += speedY;

            // Bounce off the sides of the canvas
            if (animating) {
                if (posX <= 0 || posX + width >= canvas.getWidth()) {
                    speedX = -speedX;
                }

                // Bounce off the top and bottom of the canvas
                if (posY <= 0 || posY + height >= canvas.getHeight()) {
                    speedY = -speedY;
                }
                ball.setPosition(posX, posY);
            } else{
                ball.setPosition(250, 700);
            }
        });
        canvas.add(ball);
    }
}