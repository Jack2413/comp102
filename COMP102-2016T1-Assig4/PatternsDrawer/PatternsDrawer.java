// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 4, 
 * Name:Zhancheng Gan
 * Usercode:
 * ID:300378961
 */

import ecs100.*;
import java.awt.Color;

/** PatternsDrawer
Draw various patterns. */

public class PatternsDrawer{

    public static final double boardLeft = 50;   // Top left corner of the board
    public static final double boardTop = 50;
    public static final double boardSize = 300;  // The size of the board on the window

    /** Draw a square grid board with white squares.
     *  Asks the user for the number of squares on each side
     *
     * CORE
     */
    public void drawGridBoard(){

        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double x = boardLeft;
        double y = boardTop;
        double z = boardSize/num; //size for the square
        int rows=0;
        int verticals=0;
        while(verticals<num){
            while(rows<num){
                UI.setLineWidth(1);
                UI.drawRect(x,y,z,z);
                x=x+z;
                rows=rows+1;
            }
            y=y+z;
            x=x-num*z;
            rows=rows-num;
            verticals=verticals+1;
        }
    }

    /** Illusion
     * a pattern that makes dark circles appear in the intersections
     * when you look at it. 
     **/
    public void drawIllusion(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double x = boardLeft;
        double y = boardTop;
        double z = boardSize/num; //size for the square
        int verticals=0;
        int rows=0;
        int count=0;
        while(verticals<num){
            while(rows<num){
                UI.setColor(Color.black);
                UI.fillRect(x,y,z,z);
                UI.setColor(Color.white);
                UI.setLineWidth(z*0.25);
                UI.drawRect(x,y,z,z);
                x=x+z;
                rows=rows+1;
            }
            y=y+z;
            x=x-num*z+count*z;
            verticals=verticals+1;
            count=count+1;
            rows=count;
        }
    } 

    /** Draw a checkered board with alternating black and white squares
     *    Asks the user for the number of squares on each side
     *
     * COMPLETION
     */
    public void drawCheckersBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double x = boardLeft;
        double y = boardTop;
        double z = boardSize/num; //size for the square
        int rows=1;
        int verticals=1;
        while(verticals<=num){
            if(verticals%2==0){
                while(rows<=num){ 
                    if(!(rows%2==0)){
                        UI.fillRect(x,y,z,z);
                    }
                    UI.setLineWidth(1);
                    UI.drawRect(x,y,z,z);
                    x=x+z;
                    rows=rows+1;
                }
            }
            else{
                while(rows<=num){
                    if(rows%2==0){
                        UI.fillRect(x,y,z,z);
                    }
                    UI.setLineWidth(1);
                    UI.drawRect(x,y,z,z);
                    x=x+z;
                    rows=rows+1;
                }
            }
            y=y+z;
            x=x-num*z;
            rows=rows-num;
            verticals=verticals+1;
        }
    }

    /** Draw a board made of concentric circles, 2 pixel apart
     *  Asks the user for the number of squares on each side
     *The larger the cells of the grid (ie, the fewer number of cells) the more circles there will be.
     */
    public void drawConcentricBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double x = boardLeft;
        double y = boardTop;
        double z = boardSize/num;//size for the square,circle
        double cy = y+z/2; // circle top
        double cx = x+z/2;
        double count = 0;// circle left
        int verticals=0;
        int rows=0;
        while(verticals<num){
            while(rows<num){
                while(0<z){
                    UI.drawOval(cx,cy,z,z);
                    cx=cx+2;
                    cy=cy+2;
                    z=z-4;
                    count++;
                }
                z=boardSize/num;
                cx = cx-count*2;
                cy = cy-count*2;
                cx = cx+z+1;
                count=0;//next starting piont
                rows++;//count
            }
            z=boardSize/num;
            cx = cx-count*2;
            cy = cy-count*2;
            cx = cx-num*z-num;
            cy = cy+z+1;
            count=0;
            rows=0;
            verticals++;//count
        }

        //draw one circle first.
        //then while inside while rows while vertiacls
        //inside 2 pixel apart, outside 1 pixel.

    }

    /** ---------- The code below is already written for you ---------- **/
    public PatternsDrawer(){
        UI.addButton("Clear",UI::clearPanes);
        UI.addButton("Core: Grid", this::drawGridBoard);
        UI.addButton("Core: Illusion", this::drawIllusion);
        UI.addButton("Completion: Checkers", this::drawCheckersBoard);
        UI.addButton("Challenge: Concentric", this::drawConcentricBoard);
        UI.addButton("Quit",UI::quit);
    }   

}
