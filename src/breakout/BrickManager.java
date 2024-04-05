package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BrickManager extends GraphicsGroup {

    private CanvasWindow canvas;
    private static final double WIDTH = 60;
    private static final double HEIGHT = 20;
    private static final int spacing = 5;
    private List<Brick> bricksRemaining;
    
    public BrickManager(CanvasWindow canvas) {

        this.canvas = canvas;
        addBrick();

    }

    // Create a Brick Wall at different positions with different colors.
    public void addBrick() {

        bricksRemaining = new ArrayList<Brick>();

        for (int n = 100; n < 340; n += 20 + spacing){
            for (int i = 10; i < 580; i+= 60 + spacing){
            
                Brick brick = new Brick(i, n, WIDTH, HEIGHT, this);
                bricksRemaining.add(brick); 
                if (n >= 100 && n <= 140){
                    brick.setFillColor(new Color(162, 80, 128));
                }
                if (n >= 140 && n <= 180){
                    brick.setFillColor(new Color(228,156,173));
                }
                if (n >= 180 && n <= 220){
                    brick.setFillColor(new Color(243,177,167));
                }
                if (n >= 220 && n <= 260){
                    brick.setFillColor(new Color(246,216,166));
                }
                if ((n >= 260 && n <= 300)){
                    brick.setFillColor(new Color(242,234,196));
                }
                if ((n >= 300 && n <= 340)){
                    brick.setFillColor(new Color(153,149,186));
                }
                canvas.add(brick);
            }

        }
    }

    public void brickDestroyed(Brick brick){
        bricksRemaining.remove(brick);
    }

    public boolean bricksStillExist(){
        return bricksRemaining.size() > 0;
    }
}
