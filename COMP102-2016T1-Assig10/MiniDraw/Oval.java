// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import java.util.*;
import ecs100.*;
import java.awt.Color;
import java.io.*;

/** Oval represents an oval shape
 *  Implements the Shape interface.
 *  Needs fields to record the position, size, and colour
 */

public class Oval implements Shape {
    private double sx;  
    private double sy;
    private double wd;  
    private double ht;
    private Color col;
    private double px;//pressedx
    private double py;//pressedy

    /** Constructor with explicit values
     *  Arguments are the x and y of the top left corner,
     *  the width and height, and the color.  
     */
    public Oval (double x, double y, double wd, double ht, Color col){
        this.sx = x;
        this.sy = y;
        this.wd = wd;
        this.ht = ht;
        this.col = col;

    }

    /** [Completion] Constructor which reads values from a String
     *  that contains the specification of the Oval. 
     *  The format of the String is determined by the toString method.
     *     The first 3 integers specify the color;
     *     the following four numbers specify the position and the size.
     */
    public Oval(String description) {
        Scanner data = new Scanner(description);
        int red = data.nextInt();
        int green = data.nextInt();
        int blue = data.nextInt();
        this.col = new Color(red, green, blue);
        this.sx = data.nextDouble();
        this.sy = data.nextDouble();
        this.wd = data.nextDouble();
        this.ht = data.nextDouble();

    }
    /** Returns true if the point (u, v) is on top of the shape */
    public boolean on(double u, double v){
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        this.px=u;
        this.py=v;
        if((Math.pow((u-(sx+wd/2)),2))/Math.pow((wd/2),2)+Math.pow((v-(sy+ht/2)),2)/Math.pow((ht/2),2)<=1){
            return true;
            
        }
        else{
            return false;
        }// to make this class compile. PLEASE FIX THIS LINE
    }

    /** Changes the position of the shape by dx and dy.
     *  If it was positioned at (x, y), it will now be at (x+dx, y+dy)
     */
    public void moveBy(double dx, double dy){
        this.sx += dx;
        this.sy += dy;

    }

    /** Draws the oval on the graphics pane. 
     *  It draws a black border and fills it with the color of the oval.
     */
    public void redraw(){
        UI.setColor(this.col);
        UI.fillOval(this.sx,this.sy,this.wd,this.ht);

    }

    /** [Completion] Changes the width and height of the shape by the
     *  specified amounts.
     *  The amounts may be negative, which means that the shape
     *  should get smaller, at least in that direction.
     *  The shape should never become smaller than 1 pixel in width or height
     *  The center of the shape should remain the same.
     */
    public void resize(double changeWd, double changeHt){
        
        if(changeWd>=0&&changeHt>=0&&px>=(sx+wd/2)&&py>=(sy+ht/2)){// dir bot right && cheak potsiton
            this.wd += changeWd; //do action
            this.ht += changeHt;
        }
        else if(changeWd>=0&&changeHt<=0&&px>=(sx+wd/2)&&py<=(sy+ht/2)){// dir top right
            this.sy += changeHt;
            this.wd += changeWd;
            this.ht -= changeHt;
        }
        else if(changeWd<=0&&changeHt>=0&&px<=(sx+wd/2)&&py>=(sy+ht/2)){// dir bot left
            this.sx += changeWd;
            this.wd -= changeWd;
            this.ht += changeHt;
        }
        else if(changeWd<=0&&changeHt<=0&&px<=(sx+wd/2)&&py<=(sy+ht/2)){// dir top right
            this.sx += changeWd;
            this.sy += changeHt;
            this.wd -= changeWd;
            this.ht -= changeHt;
        }

        else if(changeWd>=0&&changeHt>=0&&px<=(sx+wd/2)&&py<=(sy+ht/2)){
            this.sx += changeWd;
            this.sy += changeHt;
            this.wd -= changeWd;
            this.ht -= changeHt;

        }
        else if(changeWd>=0&&changeHt<=0&&px<=(sx+wd/2)&&py>=(sy+ht/2)){
            this.sx += changeWd;
            this.wd -= changeWd;
            this.ht += changeHt;
        }
        else if(changeWd<=0&&changeHt>=0&&px>=(sx+wd/2)&&py<=(sy+ht/2)){
            this.sy += changeHt;
            this.wd += changeWd;
            this.ht -= changeHt;
        }
        else if(changeWd<=0&&changeHt<=0&&px>=(sx+wd/2)&&py>=(sy+ht/2)){
            this.wd += changeWd;
            this.ht += changeHt;
        }
        if(this.wd<20){
            this.wd=20;
        }
        if(this.ht<20){
            this.ht=20;
        }
    }

    /** Returns a string description of the oval in a form suitable for
     *  writing to a file in order to reconstruct the oval later
     *  The first word of the string must be Oval 
     */
    public String toString(){
        return ("Oval "+col.getRed()+" "+col.getGreen()+" "+col.getBlue()+" "+this.sx+" "+this.sy+" "+this.wd+" "+this.ht);

        // to make this class compile. PLEASE FIX THIS LINE
    }

}
