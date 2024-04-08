package breakout;

import edu.macalester.graphics.Rectangle;

public class Brick extends Rectangle {

    private static final double WIDTH = 60;
    private static final double HEIGHT = 20;
    private BrickManager manager;
    boolean destroyed;

    // Creates a Rectangle with a specified width and height
    public Brick(double x, double y, double width, double height, BrickManager manager){
        super(x, y, WIDTH, HEIGHT);
        destroyed = false;
        setStrokeColor(null);
        this.manager = manager;
    }

    public boolean isDestroyed(){
        return destroyed;
    }

    public void setDestroyed(){
        this.destroyed = true;
        manager.brickDestroyed(this);
    }

}
