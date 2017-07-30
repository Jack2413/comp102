// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 6
 * Name:Zhancheng Gan   
 * Usercode:ganzhan
 * ID:300378961
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JButton;
import javax.swing.*;

public class MiniPaint{

    // fields to remember:
    //  - the shape that will be drawn when the mouse is next released.
    //  - whether the shape should be filled or not
    //  - the position the mouse was pressed, 
    //  - the name of the image file
    double pressedX;
    double pressedY;
    double releasedX;
    double releasedY;
    double dragedX;
    double dragedY;
    double startX;
    double startY;
    double height;
    double width;
    double size;
    Color color;
    boolean Fill = false;
    String Doaction = "Line";
    String filename;
    JButton button1;
    //Constructor
    /** Sets up the user interface - mouselistener and buttons */
    public MiniPaint(){
        UI.setMouseMotionListener(this::doMouse);
        button1 = UI.addButton("Set Color",this::doChooseColour);
        UI.addButton("Line", ()->{this.Doaction = "Line";});       
        UI.addButton("Rect",()->{this.Doaction = "Rect";});
        UI.addButton("Oval",()->{this.Doaction = "Oval";});
        UI.addButton("Image", this::Image);
        UI.addButton("Fill/NOFill",this::FillorNOFill);
        UI.addButton("Eraser",()->{this.Doaction = "eraser";});
        UI.addButton("Pen",()->{this.Doaction = "pen";});
        UI.addButton("concentric rings",()->{this.Doaction = "concentric rings";});
        UI.addSlider("Size",1,100,1,this::setsize);
        UI.addButton("Clear",UI::clearPanes);
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Respond to mouse events
     * When pressed, remember the position.
     * When released, draw the current shape using the pressed position
     *  and the released position.
     * Uses the value in the field to determine which kind of shape to draw.
     * Although you could do all the drawing in this method,
     *  it may be better to call some helper methods for the more
     *  complex actions (and then define the helper methods!)
     */
    public void doMouse(String action, double x, double y) {   
        UI.println(action);
        if(action.equals("pressed")){
            this.pressedX=x;
            this.pressedY=y;
            this.dragedX=pressedX;
            this.dragedY=pressedY;
        }

        else if(action.equals("dragged")){
            if(Doaction.equals("eraser")){
                UI.setLineWidth(size);
                UI.eraseLine(dragedX,dragedY,x,y);
                dragedX =x;
                dragedY =y;
            }
            if(Doaction.equals("pen")){
                UI.setLineWidth(size);
                UI.drawLine(dragedX,dragedY,x,y);
                dragedX =x;
                dragedY =y;
            }
        }
        else if (action.equals("released")){
            this.releasedX=x;
            this.releasedY=y;
            this.startX = Math.min(pressedX,releasedX);
            this.startY = Math.min(pressedY,releasedY);
            this.height = Math.abs(releasedY-pressedY);
            this.width = Math.abs(releasedX-pressedX);
            if(Doaction.equals("Image")){
                this.drawAnImage(width,height);
            }
            else if(Doaction.equals("Rect")){
                this.drawARectangle(width,height);
            }
            else if (Doaction.equals("Oval")){
                this.drawAnOval(width,height);
            }
            else if(Doaction.equals("Line")){
                this.drawLine(x,y);
            }
            else if(Doaction.equals("concentric rings")){
                this.drawconcentric_rings(width,width);
            }
        }
    }

    /* Helper methods for drawing the shapes, if you choose to define them 
    I used the following methods:

    public void drawARectangle(double x, double y)
    // draws a Rectangle between the mouse pressed and mouse released points.

    public void drawAnOval(double x, double y)
    // draws a Rectangle between the mouse pressed and mouse released points.

    public void drawAnImage(double x, double y)
    // draws an image at the mouse released point.

     */
    public void drawARectangle(double x,double y){
        UI.setLineWidth(size);
        if(Fill){UI.fillRect(startX,startY,x,y);}
        else{UI.drawRect(startX,startY,x,y);}
    }

    public void drawLine(double x, double y){
        UI.setLineWidth(size);
        UI.drawLine(startX,startY,x,y);
    }

    public void drawAnOval(double x, double y){
        UI.setLineWidth(size);
        if(Fill){UI.fillOval(startX,startY,x,y);}
        else{UI.drawOval(startX,startY,x,y);}
    }

    public void drawAnImage(double x, double y){
        UI. drawImage(filename, startX, startY, x, y);
    }

    public void doChooseColour(){
        this.color = JColorChooser.showDialog(null,"choose Color",this.color);
        UI.setColor(this.color);
        this.color = color;
        button1. setBackground(this.color);
        button1.setForeground(this.color);
    }

    public void Image(){
        this.filename = UIFileChooser.open("Choose a file");
        this.Doaction = "Image";    
    }

    public void FillorNOFill(){
        if(this.Fill){
            this.Fill = false;
            UI.eraseString("Fill",10,20);
            UI.drawString("NOFill",10,20);
        }
        else{
            this.Fill = true;
            UI.eraseString("NOFill",10,20);
            UI.drawString("Fill",10,20);
        }
    }

    public void drawconcentric_rings(double width, double hight){
        UI.setLineWidth(size);

        while(width>0&&hight>0){
            UI.drawOval(startX,startY,width,hight);
            startX+=5;
            startY+=5;
            width-=10;
            hight-=10;
        }

    }

    public void setsize(double value){
        this.size = value;
    }

    // Main:  constructs a new MiniPaint object
    public static void main(String[] arguments){
        new MiniPaint();
    }        
}
