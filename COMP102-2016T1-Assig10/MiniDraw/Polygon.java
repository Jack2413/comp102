// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import java.util.*;
import ecs100.*;
import java.awt.Color;
import java.io.*;

/** Polygon represents a polygon made of a sequence of straight lines.
 *  Implements the Shape interface.
 *  Has a field to record the colour of the line and two fields to store
 *  lists of the x coordinates and the y coordinates of all the vertices
 */

public class  Polygon implements Shape {
    private ArrayList<Double> sx=new ArrayList<Double>();
    private ArrayList<Double> sy=new ArrayList<Double>();
    private Color col;
    
    public Polygon(double x, double y, Color col){
        this.sx.add(x);
        this.sy.add(y);
        this.col = col;
    
    
    }
    
    public void addxy(double x, double y){
        this.sx.add(x);
        this.sy.add(y);
    
    
    }
    
    public void redraw(){
        UI.setColor(this.col);
        int length = this.sx.size();
        double[]x=new double[length]; 
        double[]y=new double[length];
        for(int i=0;i<length;i++){
            x[i]=this.sx.get(i);
            y[i]=this.sy.get(i);
            
        
        }
        UI.drawPolygon(x,y,length);
    
    }
    public void resize (double changeWd, double changeHt);
    
    public void moveBy(double changeX, double changeY){
        for(int i =0; i<this.sx.size();i++){
            this.sx.set(i,this.sx.get(i)+changeX);
            this.sy.set(i,this.sy.get(i)+changeY);
        }
    
    }
    

}
