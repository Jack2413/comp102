// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.awt.Color;
import java.io.*;

/** Dot represents a small circle shape of a fixed size (5 pixels)
 *   Implements the Shape interface.
 *   Needs fields to record the position, and colour
 */

public class Dot implements Shape{
    //fields
    private double sx;  
    private double sy;
    private double wd;  
    private double ht;
    private Color col;
    private double px;//pressedx
    private double py;//pressedy

     
    public Dot (double x, double y, double wd, double ht, Color col) {
        this.sx = x;
        this.sy = y;
        this.wd = 5;
        this.ht = 5;
        this.col = col;

    }

    public Dot(String description) {
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

    public boolean on(double u, double v) {
        this.px=u;
        this.py=v;
        if(u>this.sx&&u<(this.sx+this.wd+5)&&v>this.sy&&v<(this.sy+this.ht+5)){
            return true;
        }
        else{
            return false;
        }// to make this class compile. PLEASE FIX THIS LINE

    }

    public void moveBy(double dx, double dy) {
        this.sx += dx;
        this.sy += dy;

    }

    public void redraw() {
        UI.setColor(this.col);
        UI.fillOval(this.sx,this.sy,this.wd,this.ht);

    }

    public void resize (double changeWd, double changeHt) {
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


        if(this.wd<5){
            this.wd=5;
        }
        if(this.ht<5){
            this.ht=5;
        }

    }
    public String toString() {
        return ("Dot "+col.getRed()+" "+col.getGreen()+" "+col.getBlue()+" "+this.sx+" "+this.sy+" "+this.wd+" "+this.ht);

        // to make this class compile. PLEASE FIX THIS LINE
    }

}
/*# YOUR CODE HERE */
