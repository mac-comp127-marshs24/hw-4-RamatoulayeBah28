package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.*;

public class BrickManager extends GraphicsGroup {

    double width = 45;
    double height = 7;
    
    public BrickManager(CanvasWindow canvas) {
        double centerX = 3;
        double centerY = 100;
        for (int i = 0; i < 23; i++)
        {
            for (int j = 0; j < 20; j++) 
            {
                Rectangle brick = new Rectangle(centerX, centerY, width, height);
                brick.setFilled(true);
                brick.setFillColor(Color.BLACK);
                brick.setStroked(false);
                canvas.add(brick);
                centerY+= 10;
                j++;
            }
            centerY = 100;
            centerX+= 50;
            i++;
        }              
        

    }
    
}
