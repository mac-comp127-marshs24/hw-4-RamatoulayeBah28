package breakout;

import java.awt.Color;

import edu.macalester.graphics.*;

public class Paddle extends Rectangle {

    public double centerX, centerY, width, height;
    
    // Constructor: Creates a rectangle for the paddle with a specified width, height and position
    public Paddle(double centerX, double centerY, double width, double height) {
                        
        super(centerX, centerY, width, height); 
        this.setFillColor(Color.black);

    }
 }
   
