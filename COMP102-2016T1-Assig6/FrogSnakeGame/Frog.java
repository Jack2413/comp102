// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** Frog
 *  A new frog starts at the given position, with the given direction, and 
 *     has either a "light" or "dark" shade.
 *  Frogs can turn in 4 directions: left, right, up, and down. 
 *  Frogs move around at a constant speed in an arena with an enclosing wall,
 *     following its direction, until it hits a wall. In which case it stops moving.
 *  Frog can grow in size, and (for the completion) can also shrink by resetting their size
 *      to the orginal value.
 *
 *  The walls of the arena are determined by the constants:
 *    FrogGame.TopWall, FrogGame.BotWall, FrogGame.LeftWall and FrogGame.RightWall
 */

public class Frog {
    // Constants
    public static final int INITIAL_SIZE = 30;
    public static final int GROWTH_RATE = 1;
    public static final int SPEED = 2;

    public static final int DELAY = 20;
    // Fields
    public double x;
    public double y;

    private double left;
    private double top;
    private String dir;
    private String shade;
    private double frogsize = INITIAL_SIZE;

    private double xBug;
    private double yBug;

    //socreboard
    private int score = 0;
    private int level = 1;
    private int growth= 1;
    private int lifes = 100;
    private double AISPEED = 1;

    //Constructor 
    /** 
     * Make a new frog
     * The parameters specify the initial position of the top left corner,
     *   the direction, and the shade of the Frog ("light" or "dark")
     * We assume that the position is within the boundaries of the arena
     */
    public Frog(double left, double top, String dir, String shade)  {
        this.left=left;
        this.top=top;
        this.dir=dir;
        this.shade=shade;
        this.draw();
    }

    /**
     * Turn right
     */
    public void turnRight(){
        this.dir = "Right";

    }

    /**
     * Turn left
     */
    public void turnLeft(){
        this.dir = "Left";

    }

    /**
     * Turn up
     */
    public void turnUp(){
        this.dir = "Up";

    }

    /**
     * Turn down
     */
    public void turnDown(){
        this.dir = "Down";

    }
    
    public void turnUpLeft(){
        this.dir = "UpLeft";
    }
    
    public void turnUpRight(){
        this.dir = "UpRight";
    }
    
    public void turnDownLeft(){
        this.dir = "DownLeft" ;  
    }
    
    public void turnDownRight(){
        this.dir = "DownRight";
    }
    
    

    /**
     * Moves the frog: 
     *   use SPEED unit forward in the correct direction
     *   by changing the position of the frog.
     * Make sure that the frog does not go outside the arena, by making sure 
     *  - the top of the frog is never smaller than FrogGame.TopWall
     *  - the bottom of the frog is never greater than FrogGame.BotWall
     *  - the left of the frog is never smaller than FrogGame.LeftWall
     *  - the right of the frog is never smaller than FrogGame.RightWall
     */
    public void move() {
        if(dir.equals("Right")){
            this.left=this.left + SPEED;
        }
        if(dir.equals("Left")){
            this.left=this.left - SPEED;
        }
        if(dir.equals("Up")){
            this.top=this.top - SPEED;
        }
        if(dir.equals("Down")){
            this.top=this.top + SPEED;
        }
        
        if(dir.equals("UpLeft")){
            this.top-=SPEED;
            this.left-=SPEED;
        }
        if(dir.equals("UpRight")){
            this.top-=SPEED;
            this.left+=SPEED;
        }
        if(dir.equals("DownLeft")){
            this.top+=SPEED;
            this.left-=SPEED;
        }
        if(dir.equals("DownRight")){
            this.top+=SPEED;
            this.left+=SPEED;
        }
        if(this.top<FrogGame.TopWall){
            this.top=this.top+SPEED;
        }
        if(this.left<FrogGame.LeftWall){
            this.left=this.left+SPEED;
        }
        if(this.top+frogsize>FrogGame.BotWall){
            this.top=this.top-SPEED;
        }
        if(this.left+frogsize>FrogGame.RightWall){
            this.left=this.left-SPEED;
        }
    }

    public void AImove(double xBug,double yBug, double level){
        this.xBug=xBug;
        this.yBug=yBug;

        if(this.top<yBug){
            this.top+=AISPEED+level*0.2;
        }       
         if(this.left<xBug){
            this.left+=AISPEED+level*0.2;
        }
        if(this.top>yBug){
            this.top-=AISPEED+level*0.2;
        }
         if(this.left>xBug){
            this.left-=AISPEED+level*0.2;
        }
        if(this.top<FrogGame.TopWall){
            this.top+=AISPEED+level*0.2;
        }
        if(this.left<FrogGame.LeftWall){
            this.left+=AISPEED+level*0.2;
        }
        if(this.top+frogsize>FrogGame.BotWall){
            this.top-=AISPEED+level*0.2;
        }
        if(this.left+frogsize>FrogGame.RightWall){
            this.left-=AISPEED+level*0.2;
        }
    }

    /**
     * Check whether the frog is touching the given point, eg, whether the
     *   given point is included in the area covered by the frog.
     * Return true if the frog is on the top of the position (x, y)
     * Return false otherwise
     */
    public boolean touching(double x, double y) {
        this.x=x;
        this.y=y;
        if(this.y>this.top&&this.y<(this.top+frogsize)&&this.x>this.left&&this.x<(this.left+frogsize)){
            return true;
        }
        else{
            return false;
        }       
    }

    /**
     * The Frog has just eaten a bug
     * Makes the frog grow larger by GROWTH_RATE.
     */
    public void grow(){
        this.frogsize=this.frogsize + GROWTH_RATE;

    }

    /**
     * The Frog has just bumped into a snake
     * Makes the frog size reset to its original size
     * ONLY NEEDED FOR COMPLETION
     */
    public void shrink(){
        this.frogsize=this.INITIAL_SIZE;
        this.growth = 0;

    }

    public int score(int growth){
        return score=score+1+growth/5;
    }

    public int growth(){
        return growth++;
    }

    public int lifes(){
        return lifes--;
    }

    /**
     * Draws the frog at the current position.
     */
    public void draw(){
        if(this.shade.equals("light")){
            UI.drawImage("lightfrog.jpg",this.left,this.top,this.frogsize,this.frogsize);
        }
        else{
            UI.drawImage("darkfrog.jpg",this.left,this.top,this.frogsize,this.frogsize);
        }

    }
}

