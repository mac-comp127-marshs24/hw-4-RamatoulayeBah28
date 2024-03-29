package breakout;

import java.awt.Color;

import edu.macalester.graphics.*;

public class Paddle extends GraphicsGroup {
    double centerX = 250;
    double centerY = 700;
    double width = 50;
    double height = 7;
    

    public Paddle(CanvasWindow canvas) {
                        
        Rectangle paddle = new Rectangle(centerX, centerY, width, height);
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);
        paddle.setStroked(false);

        canvas.add(paddle);


    }

    

        
    
   
}
